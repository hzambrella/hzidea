package com.hz.spring;

import com.hz.pojo.PojoC;

import java.util.Arrays;

public class Main2 {

    public static  void main(String[] args){
        PojoC c=new PojoC();
        //String haha="/1"; //[,1]
        String haha="";//[]
        System.out.println(Arrays.toString(haha.split("/")));
    }
}
