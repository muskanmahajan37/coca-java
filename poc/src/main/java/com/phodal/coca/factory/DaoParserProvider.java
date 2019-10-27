package com.phodal.coca.factory;

public interface DaoParserProvider {
    DaoParserTypeEnum getDaoParserType();

    String getDaoParseRootPath();
}
