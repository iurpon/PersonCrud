package ru.trandefil.tm.util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUniqueString(){
        return UUID.randomUUID().toString();
    }
}
