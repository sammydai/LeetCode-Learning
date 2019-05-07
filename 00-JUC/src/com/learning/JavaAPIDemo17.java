 package com.learning;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo17 {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
        ThreadPoolExecutor pool = 
            new ThreadPoolExecutor(1, 2, 6, TimeUnit.SECONDS, queue,Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        for (int x = 0; x < 5; x++) {
            int temp = x;
            pool.execute(()->{
                System.out.println("BEFORE"+Thread.currentThread().getName()+"开始执行任务-x= "+temp);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                     e.printStackTrace();
                }
                System.out.println("AFTER"+Thread.currentThread().getName()+"任务执行结束-x "+temp);

            });
        }
    }
}
