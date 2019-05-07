 package com.learning;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo5 {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2);//当凑够2个线程就进行触发
        for (int x = 0; x < 3; x++) {
            int sec = x ;
            new Thread(()->{ 
                System.out.println("【"+Thread.currentThread().getName()+"】 - 等待开始。"); 
                try {
//                    cb.await();
                    if (sec == 2) { // 重置
                      cb.reset();
                      System.out.println("【重置处理】*******"+Thread.currentThread().getName());
                    } else {
                        TimeUnit.SECONDS.sleep(sec);
                        cb.await(5, TimeUnit.SECONDS);//等待处理
                    }
            } catch (Exception e) {
                 e.printStackTrace();
            }
               System.out.println("【"+Thread.currentThread().getName()+"】 - 等待结束。"); 

            },"娱乐者-"+x).start();
        }

//        System.out.println("【*****主线程*****】所有的程序执行完毕.");
    }
     
}
