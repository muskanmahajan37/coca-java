package com.phodal.coca;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

class Main {
    public static void main(String[] args) {
        try {

            InputStream inputStream = Main.class.getResourceAsStream("/Example.java");
            Lexer lexer = new Java8Lexer(CharStreams.fromStream(inputStream));

            TokenStream tokenStream = new CommonTokenStream(lexer);
            Java8Parser java8Parser = new Java8Parser(tokenStream);

            java8Parser.setBuildParseTree(true);
            ParseTree tree = java8Parser.compilationUnit(); // parse

            Java8ParserBaseVisitor Visitor = new Java8ParserBaseVisitor();
            Object result = Visitor.visit(tree);

            System.out.println(tree.toStringTree(java8Parser));
            System.out.println("visitor result = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}