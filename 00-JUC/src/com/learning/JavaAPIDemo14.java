 package com.learning;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo14 {
     public static void main(String[] args) throws Exception {
        Set<Callable<String>> tasks = new HashSet<Callable<String>>();
        for (int x = 0; x < 10; x++) {
            int temp = x;
            tasks.add(()->{
                return Thread.currentThread().getName()+"执行操作-"+temp;
            });
        }
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<String>> invokeAll = service.invokeAll(tasks);
        for (Future<String> future : invokeAll) {
            System.out.println("返回结果： "+future.get());
        }
        service.shutdown();
    }
}
