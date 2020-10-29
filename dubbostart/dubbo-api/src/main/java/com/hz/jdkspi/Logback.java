package com.hz.jdkspi;

public class Logback implements Log {

    public void info(String info) {
        System.out.println("Logback:"+info);
    }
}
