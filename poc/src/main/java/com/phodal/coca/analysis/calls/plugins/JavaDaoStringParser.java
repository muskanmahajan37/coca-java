package com.phodal.coca.analysis.calls.plugins;

import com.phodal.coca.analysis.calls.JavaDaoParser;
import com.phodal.coca.analysis.calls.model.JMethodCall;

public class JavaDaoStringParser implements JavaDaoParser {
    @Override
    public void parse(JMethodCall currentMethodCall, String body) {
        System.out.println(body);
    }
}
