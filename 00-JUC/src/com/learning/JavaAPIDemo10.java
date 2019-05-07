 package com.learning;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo10 {
     public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor(); // 线程池只能有1个人
        for (int x = 0; x < 10; x++) {
            service.submit(()->{ //线程池会负责启动
                System.out.println(Thread.currentThread().getName()+"执行操作");
            });
        }
        service.shutdown(); //线程池执行完毕后关掉
    }
}
