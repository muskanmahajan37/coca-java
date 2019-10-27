package com.phodal.coca;

import com.phodal.coca.analysis.JavaCallApp;
import com.phodal.coca.analysis.calls.plugins.JavaDaoStringParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseJava {
    public void startParse() throws IOException {
        JavaDaoStringParser javaDaoStringParser = new JavaDaoStringParser();

        String file = new File("src/main/resources/Example.java").getAbsolutePath();
        Path path = Paths.get(file);
        JavaCallApp javaCallApp = new JavaCallApp(javaDaoStringParser);
        List<String> clzs =  new ArrayList<>();

        javaCallApp.parse(path, clzs);
    }
}
