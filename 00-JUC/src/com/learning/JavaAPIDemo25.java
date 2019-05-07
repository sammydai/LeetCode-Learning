 package com.learning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
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
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo25 {
    public static void main(String[] args) {
        BlockingDeque<String> deque = new LinkedBlockingDeque<String>(); 
        
            new Thread(()->{
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("【[FIRST]消费数据{"+Thread.currentThread().getName()+"}】 "+deque.takeFirst());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                    }

                }
            },"消费者-FIRST").start();
        
            new Thread(()->{
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("【[LAST]消费数据{"+Thread.currentThread().getName()+"}】 "+deque.takeLast());
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                    }

                }
            },"消费者-LAST").start();
            
        for (int x = 0; x < 3; x++) {
            new Thread(()->{
                for (int y = 0; y < 5; y++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        String str = null;
                        if (y % 2 ==0) {
                            str = "【[FIRST]生产数据{"+Thread.currentThread().getName()+"}】y = "+y;
                            deque.addFirst(str);
                        }else {
                            str = "【[LAST]生产数据{"+Thread.currentThread().getName()+"}】y = "+y;
                            deque.addLast(str);
                        }
//                        System.out.println(str);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                    }
                }
            },"生产者-"+x).start();
        }
    }
}
