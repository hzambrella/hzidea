package com.ideahz;

import java.math.BigDecimal;

public class TestFloat {

    public static void main(String[]args){
        String f1="0.011111111111111112";
        System.out.println(f1.length()-2);
        String f2="0.1111111111111111";
        System.out.println(f2.length()-2);
        double d1=0.0111111111111111111111111111111111111111111111;
        System.out.println(d1);
        double d2=0.0111111111111111111111111111111111111111111111;
        System.out.println(d2);

        double d3=0.553;
        double d4=0.23;
        System.out.println(d3-d4);

        System.out.println((new BigDecimal("0.553")).subtract(new BigDecimal("0.23")).doubleValue());
    }
}
