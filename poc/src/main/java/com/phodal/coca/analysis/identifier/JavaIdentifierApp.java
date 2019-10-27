package com.phodal.coca.analysis.identifier;


import com.phodal.coca.JavaParserBaseVisitor;
import com.phodal.coca.analysis.utils.ProcessFiles;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JavaIdentifierApp {
    public JavaIdentifierApp() {

    } 
  
    public void analysisDir(String dir) throws IOException, InterruptedException, ExecutionException {
        Path startingDir = Paths.get(dir);
        int poolSize = 8;
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        List<Future> futures = new ArrayList<>();
        ProcessFiles pf = new ProcessFiles(this::parse, pool,futures);
        Files.walkFileTree(startingDir, pf);
        for(Future f: futures) {
            f.get();
        }
        pool.shutdown();
    }

    public void parse(Path path) {
        try {

            boolean availableJavaFile = !path.toString().endsWith("Tests.java")
                    && !path.toString().endsWith("Test.java") && path.toString().endsWith(".java");
            if (availableJavaFile) {
                ParseTree tree = JavaFileParser.parse(path);
                JIdentifier interfaceIdent = new JIdentifier();
                JavaParserBaseVisitor interfaceVisitor = new JavaIdentifierVisitor(interfaceIdent);
                interfaceVisitor.visit(tree);
                if (interfaceIdent.getName() != null && !interfaceIdent.getName().equals("")) {
//                    identStore.save(interfaceIdent);
                    System.out.println(interfaceIdent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
