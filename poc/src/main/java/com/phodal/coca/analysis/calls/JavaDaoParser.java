package com.phodal.coca.analysis.calls;

import com.phodal.coca.analysis.calls.model.JMethodCall;

public interface JavaDaoParser {
    void parse(JMethodCall currentMethodCall, String body);
}
