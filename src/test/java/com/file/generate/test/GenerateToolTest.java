package com.file.generate.test;


import com.file.generate.util.ReplacementUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class GenerateToolTest {

    @Test
    public void test() throws IOException {
        String userFile="./src/test/resources/files/UserInfo.txt";
        String contentFile="./src/test/resources/files/Template.sql";
        System.out.println(new File(".").getCanonicalPath());
        ReplacementUtil util=new ReplacementUtil();
        util.generateNewSQLFile(userFile,contentFile);
    }
}
