package com.freeman.fexparser.parser.markdown;

import java.util.Map;

public class MyGenThreadLocal {
    public static ThreadLocal<Map<String,Object>> t = new ThreadLocal<Map<String,Object>>();
}
