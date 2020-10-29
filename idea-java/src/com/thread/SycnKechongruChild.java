package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 锁重入吗
 */
public class SycnKechongruChild extends SycnKechongru{
    public int c2;

    @Override
    public synchronized void add(){
        c2++;
        bb();
        super.add();
        super.getCount();
    }

    public synchronized void bb() {
        //donothing
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }

    public static void test1()throws InterruptedException {
        SycnKechongruChild c=new SycnKechongruChild();
        CountDownLatch l=new CountDownLatch(2);
        Thread t1=new Thread(getThread(c,l));
        Thread t2=new Thread(getThread(c,l));

        t1.start();
        t2.start();
        l.await();
        System.out.println(c.getCount());
        System.out.println(c.c2);
    }

    public static void test2()throws InterruptedException {
        SycnKechongruChild c=new SycnKechongruChild();
        CountDownLatch l=new CountDownLatch(2);
        ExecutorService fixPool = Executors.newFixedThreadPool(2);
        for (int i=0;i<2;i++){
            fixPool.execute(getThread(c,l));
        }

        l.await();
        fixPool.shutdown();
        System.out.println(c.getCount());
        System.out.println(c.c2);
    }


    public static Runnable getThread(SycnKechongruChild c ,CountDownLatch l){
        return new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    c.add();
                }
                l.countDown();
            }
        };
    }
}
