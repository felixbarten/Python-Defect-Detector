package ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ast.statement.Statement;
import util.StringHelper;

/**
 * Created by Nik on 25-05-15
 */
public class Module extends AstNode {

	private final String filePath;
    private final List<Statement> body;
    private final List<String> errors;

    public Module( String filePath,  Integer locInfo,  List<Statement> body) {
        super(locInfo);
	    this.filePath = filePath;
        this.body = body;
        this.errors = Collections.emptyList();
    }

    public Module( String filePath,  Integer locInfo) {
        super(locInfo);
        this.filePath = filePath;
        this.body = Collections.emptyList();
        this.errors = new ArrayList<>();
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public List<Statement> getBody() {
        return this.body;
    }

    public String getFilePath() {
        return this.filePath;
    }

	public String getName() {
		List<String> filePathParts = StringHelper.explode(this.filePath, "\\");
		String s = filePathParts.get(filePathParts.size() - 1);
		return s.substring(0, s.length() - 3);
	}

    public List<String> getErrors() {
        return this.errors;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
