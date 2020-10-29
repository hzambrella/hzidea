package com.hz.herate;

public class Child extends Parent{
    @Override
    public void a(){
        super.a();
    }
    @Override
    public void c(){
        System.out.println("c a");
    }


    public static void main(String[] args){
        Parent c=new Child();
        c.a();//问，打印什么
    }
}
