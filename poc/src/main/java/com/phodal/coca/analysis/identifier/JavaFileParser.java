package com.phodal.coca.analysis.identifier;

import com.phodal.coca.JavaLexer;
import com.phodal.coca.JavaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Path;

public class JavaFileParser {
    public static ParseTree parse(Path path) throws IOException {
        CharStream stream = CharStreams.fromPath(path);
        JavaLexer lexer = new JavaLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        return parser.compilationUnit();
    }
}
