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
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo19 {
    public static void main(String[] args) {
        Map<String,String> all = new ConcurrentSkipListMap<String, String>();
        for (int x = 0; x < 20; x++) {
            int temp = x;
            new Thread(()->{
                for (int y = 0; y < 10; y++) {
                   all.put(Thread.currentThread().getName(), " x- "+temp+" y- "+y);
                }
            }).start();
        }
        System.out.println(all.get("Thread-0"));
    }
}
