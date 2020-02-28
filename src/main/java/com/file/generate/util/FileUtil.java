package com.file.generate.util;

import com.file.generate.info.UserInfo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileUtil {


    public List<String> readFileToLines(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        Scanner scar = new Scanner(file);
        while (scar.hasNextLine()) {
            lines.add(scar.nextLine());
        }
        scar.close();
        return lines;
    }

    public String readFileToString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public List<UserInfo> readFileToUserInfo(String fileName) throws FileNotFoundException {
        List<String> contents = readFileToLines(fileName);
        List<String> keys = Arrays.asList(contents.get(0).split(","));
        List<UserInfo> userIfs = new ArrayList<>();
        for (int i = 1; i < contents.size(); i++) {
            List<String> ifs = Arrays.asList(contents.get(i).split(","));
            userIfs.add(new UserInfo(keys, ifs));
        }
        return userIfs;
    }

    public void writeToFile(List<String> contents, String fileName) throws IOException {

        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (String content : contents) {
            bw.write("-----------------------------------------------------");
            bw.newLine();
            bw.newLine();
            bw.write(content);
            bw.newLine();
            bw.newLine();
        }
        bw.close();
        fos.close();
    }

    public String getTargetFileName(String sourceFileName) {
        int index = sourceFileName.lastIndexOf(".");
        return sourceFileName.substring(0, index) + "WithUserInfo" + sourceFileName.substring(index);
    }


}
