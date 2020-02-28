package com.file.generate.info;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserInfo {


    List<String> infoKeys;
    Map<String, String> infoMap;

    public UserInfo(List<String> keys, List<String> infos) {
        infoKeys = keys;
        infoMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            infoMap.put(keys.get(i), infos.get(i));
        }
    }

    public List<String> getInfoKeys() {
        return infoKeys;
    }

    public Map<String, String> getInfoMap() {
        return infoMap;
    }

}
