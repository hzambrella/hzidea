package com.hz.jdkspi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class JdkSpiTestMain {
    public static void main(String[] args){
        //确认是不是jdk8
        List<String> list=new ArrayList();
        list.stream().filter((el)->{return el.equals("");});

        ServiceLoader s= ServiceLoader.load(Log.class);
        Iterator<Log> i=s.iterator();
        while (i.hasNext()){
            Log log=i.next();
            log.info("spi");
        }
    }
}
