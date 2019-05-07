 package com.learning;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2); //现在允许操作的资源一共有2个窗口
        Random rand = new Random(); //模拟每一个用户办理业务的时间
        for (int x = 0; x < 10; x++) {
            new Thread(()->{ //每一个线程就是一个要办理业务的人员
                if (sem.availablePermits()>0) { //现在有空余窗口
                    System.out.println("【"+Thread.currentThread().getName()+"】进入银行，此时银行没有人排队。");
                } else { //没有空余位置
                    System.out.println("【"+Thread.currentThread().getName()+"】排队等待办理业务。");
                }
                try {
                    sem.acquire(); //从信号量中获得操作许可 
                    System.out.println("【"+Thread.currentThread().getName()+"】{start}开始办理业务");
                    TimeUnit.SECONDS.sleep(rand.nextInt(5));//模拟办公延时
                    System.out.println("【"+Thread.currentThread().getName()+"】{end}结束办理业务");
                    sem.release();// 当前线程离开办公窗口
                } catch (InterruptedException e) {
                     e.printStackTrace();
                } 
            },"顾客-"+x).start();
        }
    }
     
}
