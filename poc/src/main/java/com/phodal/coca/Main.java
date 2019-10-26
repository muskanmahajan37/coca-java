package com.phodal.coca;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author Tom Everett
 */
class Main {
   public static void main(String[] args) {
      System.out.println("Antlr4 Example");
      try {
         InputStream inputStream = Main.class.getResourceAsStream("/Main.java");
         Lexer lexer = new Java8Lexer(CharStreams.fromStream(inputStream));

         TokenStream tokenStream = new CommonTokenStream(lexer);
         Java8Parser java8Parser = new Java8Parser(tokenStream);

         Java8Parser.CompilationUnitContext tree = java8Parser.compilationUnit();
         System.out.println(tree.toStringTree());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}