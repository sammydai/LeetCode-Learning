 package com.learning;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo11 {
     public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1); // 创建一个调度池
        for (int x = 0; x < 10; x++) {
            service.scheduleAtFixedRate(()->{ //线程池会负责启动
                System.out.println(Thread.currentThread().getName()+"执行操作");
            },2,2,TimeUnit.SECONDS);
        }
//        service.shutdown(); //线程池执行完毕后关掉
    }
}
