package ast;

/**
 * Created by Nik on 19-05-2015
 */
public abstract class AstNode {

    protected final Integer locInfo;

    public AstNode( Integer locInfo) {
        this.locInfo = locInfo;
    }

	public Integer getLocInfo() {
		return this.locInfo;
	}

	public abstract <T> T accept(Visitor<T> visitor);

    public Integer getLocSpan() {
        return this.locInfo;
    }
}
