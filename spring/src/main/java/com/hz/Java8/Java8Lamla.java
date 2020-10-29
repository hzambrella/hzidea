package com.hz.Java8;

import org.springframework.util.StringUtils;

import java.util.*;

public class Java8Lamla {

    String message="Java8Lamla";
    public static void main(String[]args){
        java8Tester();
    }

    public static void java8Tester(){
        new Java8Lamla().try1();
        new Java8Lamla().trySort();
    }


    public void try1(){
        DoSomething doSm=new DoSomething();
        doSm.doSomething("hahaahah",(s1)->{s1+="!";System.out.println(s1);});

        //final String final2="final2";
        String final2="final2";//隐式的final
        //不允许声明一个与局部变量同名的参数或者局部变量。
        //PrintFinaler p1=(final2)->System.out.println(final2+message+final2);
        PrintFinaler p=(a)->System.out.println(a+message+final2);

        //final2="1111";//报错，不能修改，
        message="1111";

        Thread t=new Thread(()-> p.print("111--"));
        t.run();
    }

    interface Callback{
        void cb(String result);
    }
    class DoSomething{
        void doSomething(String whatToDo,Callback callback){
            whatToDo="hz:"+whatToDo;
            callback.cb(whatToDo);
        }
    }

    interface PrintFinaler{
        void print(String a);
    }

    public void trySort(){
        String[] tosort=new String[]{"8","1","10","2","3","9","20"};
        List<String> listSort=new ArrayList();
        Collections.addAll(listSort,tosort);
        Collections.sort(listSort, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(StringUtils.toStringArray(listSort)));

        Collections.sort(listSort,(s1,s2)-> s2.compareTo(s1));
        System.out.println(Arrays.toString(StringUtils.toStringArray(listSort)));
    }




}
