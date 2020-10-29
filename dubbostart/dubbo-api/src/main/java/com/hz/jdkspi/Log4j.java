package com.hz.jdkspi;

public class Log4j implements Log {
    public static String name="Log4j";
    public void info(String info) {
        System.out.println(name+info);
    }
}
