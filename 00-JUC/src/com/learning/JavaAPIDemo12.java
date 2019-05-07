 package com.learning;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo12 {
     public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool(); // 创建一个调度池
        for (int x = 0; x < 10; x++) {
            Future<?> future = service.submit(()->{ //线程池会负责启动
                return Thread.currentThread().getName()+"执行操作";
            });
            System.out.println(future.get()); //Runnable借口没有返回值，所以返回值永远为空
        }
        service.shutdown(); //线程池执行完毕后关掉
    }
}
