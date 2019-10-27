package com.phodal.coca;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ParseJava parseJava = new ParseJava();
        parseJava.startParse();
    }
}