package com.file.generate.util;

import com.file.generate.info.UserInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReplacementUtil {

    public String replaceContentByUser(String content, UserInfo userInfo) {
        for (String key : userInfo.getInfoKeys()) {
            content = content.replaceAll("<" + key + ">", userInfo.getInfoMap().get(key));
        }
        return content;
    }


    public List<String> replaceContent(List<UserInfo> userInfos, String templateContent) {
        List<String> newContents = new ArrayList<>();
        for (UserInfo userInfo : userInfos) {
            newContents.add(replaceContentByUser(templateContent, userInfo));
            System.out.println(userInfo.getInfoMap().toString() + "  information populated.");
        }
        return newContents;
    }

    public void generateNewSQLFile(String userInfoFileName, String templateFileName) throws IOException {
        FileUtil fileUtil = new FileUtil();
        String targetFileName = fileUtil.getTargetFileName(templateFileName);
        fileUtil.writeToFile(
                replaceContent(
                        fileUtil.readFileToUserInfo(userInfoFileName),
                        fileUtil.readFileToString(templateFileName)
                ),
                targetFileName);
        System.out.println("Write to file " + targetFileName + " finished.");
    }


}
