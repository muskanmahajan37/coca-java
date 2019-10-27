package com.phodal.coca.analysis;

import com.phodal.coca.Java8ParserBaseVisitor;
import com.phodal.coca.JavaParserBaseVisitor;
import com.phodal.coca.analysis.calls.JavaCallVisitor;
import com.phodal.coca.analysis.calls.JavaDaoParser;
import com.phodal.coca.analysis.calls.model.JMethodCall;
import com.phodal.coca.analysis.identifier.JavaFileParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JavaCallApp {
    private JavaDaoParser daoParser;

    public JavaCallApp(JavaDaoParser daoParser) {
        this.daoParser = daoParser;
    }

    public void parse(Path path, List<String> clzs) throws IOException {
        System.out.println(path);

        ParseTree tree = JavaFileParser.parse(path);
        List<JMethodCall> calls = new ArrayList<>();
        JavaParserBaseVisitor visitor = new JavaCallVisitor(calls, clzs, daoParser);
        visitor.visit(tree);

        System.out.println(calls);
    }
}
