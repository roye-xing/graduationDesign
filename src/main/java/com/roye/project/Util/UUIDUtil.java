package com.roye.project.Util;

import java.sql.Timestamp;
import java.util.UUID;

public class UUIDUtil {
    //UUID
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
