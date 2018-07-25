package com.tp.bindbean.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tanping on 2018/3/19.
 */

public class BindStringUtil {


    public static boolean isEmpty(String str){
        return str == null || str.trim().equals("");
    }
    public static boolean isNotEmpty(String str){
        return str != null && !str.trim().equals("") && !str.trim().equals("null");
    }

    public static boolean isEmpty(List list){
        return list == null || list.size() == 0;
    }
    public static boolean isNotEmpty(List list){
        return list != null && list.size() != 0;
    }



}
