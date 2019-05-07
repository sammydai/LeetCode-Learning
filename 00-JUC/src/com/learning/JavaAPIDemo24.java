 package com.learning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo24 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<String>(); //允许保存5个数据队列
        for (int x = 0; x < 1; x++) {
            new Thread(()->{
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
//                        if (queue.isEmpty()) { //队列内容为空
//                            break; //结束循环
//                        }
                        System.out.println("【消费数据{"+Thread.currentThread().getName()+"}】 "+queue.take());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                    }

                }
            },"消费者-"+x).start();
        }
        for (int x = 0; x < 1; x++) {
            new Thread(()->{
                for (int y = 0; y < 5; y++) {
                    try {
//                        TimeUnit.SECONDS.sleep(1);
                        String str = "【生产数据{"+Thread.currentThread().getName()+"}】y = "+y;
                        queue.put(str); //会进入生产的阻塞状态
                        System.out.println(str);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                    }
                }
            },"生产者-"+x).start();
        }
    }
}
