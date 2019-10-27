package com.phodal.coca;

import com.phodal.coca.analysis.JavaCallApp;
import com.phodal.coca.analysis.calls.JavaDaoParser;
import com.phodal.coca.analysis.calls.plugins.JavaDaoStringParser;
import com.phodal.coca.analysis.identifier.JavaIdentifierApp;
import com.phodal.coca.factory.DaoParserProvider;
import com.phodal.coca.factory.JavaDaoParserFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ParseJava {
    public void startParse() throws IOException, ExecutionException, InterruptedException {
        JavaDaoStringParser javaDaoStringParser = new JavaDaoStringParser();
        String dir = new File("src/main/java/").getAbsolutePath();

        JavaIdentifierApp javaIdentifierApp = new JavaIdentifierApp();
        javaIdentifierApp.analysisDir(dir);

        JavaCallApp javaCallApp = new JavaCallApp(javaDaoStringParser);
        List<String> clzs =  new ArrayList<>();

        javaCallApp.analysisDir(dir, clzs);
    }
}
