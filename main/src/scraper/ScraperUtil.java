package scraper;

import java.sql.Timestamp;

/**
 * 
 * @author felix
 *	10-4-2018
 */
public class ScraperUtil {

	/**
	 * Returns current timestamp.	
	 * @return String timestamp in brackets. 
	 */
	public static String getTimestamp() {
		return "[" + new Timestamp(System.currentTimeMillis()) + "] ";
	}


}
