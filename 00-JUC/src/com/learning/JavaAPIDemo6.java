 package com.learning;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo6 {
     public static void main(String[] args) throws Exception {
         //直接利用构造方法来进行类的对象创建
        CompletableFuture<String> future = new CompletableFuture<String>(); 
        for (int x = 0; x < 10; x++) {
            new Thread(()->{
               System.out.println("BEFORE【"+Thread.currentThread().getName()+"】进入炮兵阵地，等待命令，准备开跑。"); 
               try {
                String cmd = future.get(); 
                if ("fire".equalsIgnoreCase(cmd)) {
                    System.out.println("AFTER【"+Thread.currentThread().getName()+"】接受到命令，立刻开火。");
                }
                if ("cancel".equalsIgnoreCase(cmd)) {
                    System.out.println("AFTER【"+Thread.currentThread().getName()+"】接受到撤退指令，赶紧回家。");
                }
            } catch (Exception e) {
                 e.printStackTrace();
            } 
            },"炮兵-"+x).start();
        } 
        TimeUnit.SECONDS.sleep(3); //等待3秒钟
        future.complete("cancel"); //给出了执行命令
    }
}
