 package com.learning;

 import java.util.concurrent.CountDownLatch;

public class JavaAPIDemo3 {
    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(2); //2个线程全部执行完毕后可以继续执行
        for (int x = 0; x < 2; x++) {
            new Thread(()->{ 
               System.out.println("【"+Thread.currentThread().getName()+"】线程应用执行完毕。"); 
               cdl.countDown(); //减少等待的线程个数
            },"线程对象-"+x).start();
        }
        cdl.await(); //等待计数的结束（个数为0）
        System.out.println("【*****主线程*****】所有的程序执行完毕.");
    }
     
}
