package com.file.generate;

import com.file.generate.util.ReplacementUtil;

import java.io.File;


public class GeneratorMain {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:java -jar <jar name> <UserInfo file name> <SQL Template file name>");
            return;
        }
        try {
            String currentPath = new File(".").getCanonicalPath() + "/";
            new ReplacementUtil()
                    .generateNewSQLFile(currentPath + args[0], currentPath + args[1]);
        } catch (Exception e) {
            System.err.println("Fail to generate file as " + e.getMessage());
            e.printStackTrace();
        }
    }
}
