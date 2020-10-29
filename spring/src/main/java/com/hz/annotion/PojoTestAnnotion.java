package com.hz.annotion;


import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

public class PojoTestAnnotion {
    @MyAnnotion(attr = "666")
    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<PojoTestAnnotion>c=PojoTestAnnotion.class;
        Method m=c.getMethod("test");
        System.out.println(c.isAnnotationPresent(MyAnnotion.class));
        MyAnnotion ann=m.getAnnotation(MyAnnotion.class);
        Autowired ann2=m.getAnnotation(Autowired.class);
        System.out.println(ann.attr());
        System.out.println(ann2==null);
    }
}
