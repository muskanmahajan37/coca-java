package com.phodal.coca.analysis.identifier;

import com.phodal.coca.Java8Lexer;
import com.phodal.coca.Java8Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Path;

public class JavaFileParser {
    public static ParseTree parse(Path path) throws IOException {
        CharStream stream = CharStreams.fromPath(path);
        Java8Lexer lexer = new Java8Lexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);

        return parser.compilationUnit();
    }
}
