 package com.learning;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo7 {
     public static void main(String[] args) throws Exception {
         //如果使用Runnable，那么泛型的类型必须为Void，表示没有返回值
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("【FUTURE】等着将军醒了开炮");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                 e.printStackTrace();
            }
            System.out.println("【FUTURE】醒了，开始干活");

        }); 
        for (int x = 0; x < 10; x++) {
            new Thread(()->{
               System.out.println("BEFORE【"+Thread.currentThread().getName()+"】进入炮兵阵地，等待命令，准备开跑。"); 
               try {
               
                    System.out.println("AFTER【"+Thread.currentThread().getName()+"】接受到命令，立刻开火。"+future.get());
                
               
            } catch (Exception e) {
                 e.printStackTrace();
            } 
            },"炮兵-"+x).start();
        } 
        TimeUnit.SECONDS.sleep(3); //等待3秒钟
        
    }
}
