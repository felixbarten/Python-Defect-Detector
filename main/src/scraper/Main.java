package scraper;
import util.FileHelper;
import util.Settings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

	//args = "GIT API TOKEN"
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=530" v2.5 2k   
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=531" v2.6 ~27k 
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=532" v2.7 37k 
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=533" This is the 3.0 category. Do the subversions instead. 33k projects
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=534" v3.0 800 Done
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=535" v3.1 3k Done
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=538" v3.2 5k  Done
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=566"	v3.3 Done
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=587" v3.4 23000 projects
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=607" v3.5 24000 projects
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=611" v3.6 11000 projects
	// "https://pypi.python.org/pypi?:action=browse&show=all&c=640" v3.7 800 projects
	// added categories for v3.6, v3.7
	// from: https://pypi.python.org/pypi?:action=browse&c=595
	public static void main(String[] args) throws IOException {

		Properties config = Settings.getConfig();

		PrintStream out = new PrintStream(new FileOutputStream(FileHelper.stampedFileName(config.getProperty("locations.log.out"), "out", "log")));
		PrintStream err = new PrintStream(new FileOutputStream(FileHelper.stampedFileName(config.getProperty("locations.log.error"), "err", "log")));
		System.setOut(out);
		System.setErr(err);

		PrintStream allLinks = new PrintStream(new FileOutputStream(FileHelper.stampedFileName("all_links", "txt")));
		PrintStream databaseScript = new PrintStream(new FileOutputStream(FileHelper.stampedFileName("git_locations", "csv")));
		PrintStream cloneScript = new PrintStream(new FileOutputStream(FileHelper.stampedFileName("get_data", "sh")));
		
		String token = args[0]; 
		
		List<String> versionUrls = new LinkedList<String>(Arrays.asList(args));
		versionUrls.remove(0); //remove token
		
		PyPiScraper scraper = new PyPiScraper(versionUrls);
		List<GitHubRepo> gitLinks = scraper.getAllGitRepoLinks();

		gitLinks.forEach(l -> allLinks.println(l.getUrl()));
		
		// print GitRepo objects now.
		Map<String, GitHubRepo> validGitRepos = getValidGitHubRepos(gitLinks, token);
		validGitRepos.values().stream()
				.filter(GitHubRepo::isPythonRepo)
				.forEach(r -> addToScript(cloneScript, databaseScript, r));
	}

	private static void addToScript(PrintStream cloneScript, PrintStream repoInfo, GitHubRepo repo) {
		String diskLocation = "data/" + repo.getName() + "_" + UUID.randomUUID();
		cloneScript.println("git clone " + repo.getUrl() + " " + diskLocation);
		repoInfo.println(repo.getUrl() + ";" + diskLocation);
		System.out.println(ScraperUtil.getTimestamp() + "Added repo: " + repo.getName());
	}

	public static Map<String, GitHubRepo> getValidGitHubRepos(List<GitHubRepo> repos, String token) {
		Map<String, GitHubRepo> results = new HashMap<>();
		GitHubApi gitHubApi = new GitHubApi(token);
		Map<String, Long> rateLimit = gitHubApi.getRateLimit();

		/**
		 * Every GitHub repo creates two API requests. As GitHub API logs per IP address there is no benefit to be had using alternating API keys. 
		 * Therefore, some limiting must be performed to prevent valid repos from being tossed. 
		 * Rate Limit: 5000 requests per hour. ~2500 repos /hr
		 *
		 * Every repo uses two API requests one to retrieve general project information and one to inquire about the use of programming languages. 
		 * However, if a project does not exist it will only use one request so some resyncing of the limit is preferable.
		 */
		long maxRequests = 4950;
		long apiHits = 0;
		if (rateLimit.containsKey("remaining") && rateLimit.get("remaining") > 0) {
			apiHits = maxRequests - rateLimit.get("remaining");
		}
		System.out.println(ScraperUtil.getTimestamp() + "Starting Github API Queries. Current rate limit: " + apiHits + " left");
		int loopcount = 0;
		int repocount = 0;
		for (GitHubRepo repo : repos) {
			if (apiHits <= maxRequests) {
				try {
					gitHubApi.updateRepoInfo(repo);
					if (results.containsKey(repo.getUrl())) {
						continue;
					}
					Map<String, Long> langUse = gitHubApi.getLanguageUse(repo);
					repo.setLanguageUsage(langUse);
					results.put(repo.getUrl(), repo);
				}
				catch (Exception ex) {
					ex.printStackTrace();
					repo.setLanguageUsage(Collections.emptyMap());
				}
				apiHits += 2;
				// resync apiHits every 25 projects with GitHub counter.
				loopcount++;
				repocount++;
				if (loopcount >= 25) {
					apiHits = resyncRateLimit(gitHubApi, apiHits, maxRequests);
					loopcount = 0;
				}
			} else {
				// Need to cool off. retrieve cooldown timer from /rate_limit
				rateLimit = gitHubApi.getRateLimit();
				Date reset = new Date(rateLimit.get("reset") * 1000);
				System.out.println(ScraperUtil.getTimestamp() + "Exceeded GitHub API rate limit");
				System.out.println(ScraperUtil.getTimestamp() + "Processed " + repocount + " out of " + repos.size());
				System.out.println(ScraperUtil.getTimestamp() + "Resuming again after: " + reset.toString());
				
				while (true) {
					Date now = new Date();
					if (now.after(reset)) {
						break;
					}
					try {
						Thread.sleep(180);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				apiHits = 0;
			}
		}
		return results;
	}
	
	private static long resyncRateLimit(GitHubApi api, long current, long max) {
		Map<String, Long> rateLimit = api.getRateLimit();
		if (rateLimit.containsKey("remaining") && rateLimit.get("remaining") > 0) {
			current = max - rateLimit.get("remaining");
		}
		return current;
	}
}
