package com.phodal.coca.factory;

import com.phodal.coca.analysis.calls.JavaDaoParser;
import com.phodal.coca.analysis.calls.plugins.JavaDaoStringParser;
import com.phodal.coca.analysis.calls.plugins.MyBatisParser;

public class JavaDaoParserFactory {
    private final DaoParserProvider provider;

    public JavaDaoParserFactory(DaoParserProvider provider) {
        this.provider = provider;
    }

    public JavaDaoParser createDaoParser()  {
        DaoParserTypeEnum daoParserType = this.provider.getDaoParserType();
        if(daoParserType == DaoParserTypeEnum.StringParser) {
            return new JavaDaoStringParser();
        }
        if(daoParserType == DaoParserTypeEnum.MyBatisParser) {
            return new MyBatisParser(this.provider.getDaoParseRootPath());
        }
        throw new OutOfJavaDaoParserEnumError(daoParserType);
    }

}
