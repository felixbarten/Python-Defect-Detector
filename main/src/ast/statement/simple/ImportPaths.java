package ast.statement.simple;

import java.util.List;

import ast.Visitor;
import ast.path.Path;

/**
 * Created by Nik on 25-05-15
 */
public class ImportPaths extends Import {

    public ImportPaths( Integer locInfo,  List<Path> paths) {
        super(locInfo, paths);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
