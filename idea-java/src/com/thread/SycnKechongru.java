package com.thread;

public class SycnKechongru {

    private int count=0;

    public int getCount(){
        return count;
    }

    public synchronized void add(){
        count++;
    }
}
