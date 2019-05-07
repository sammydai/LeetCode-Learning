 package com.learning;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo15 {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        CompletionService<String> completionService = new ExecutorCompletionService<String>(service);
        for (int x = 0; x < 10; x++) {
            int temp = x;
            completionService.submit(()->{
                return Thread.currentThread().getName()+" -x= "+temp;
            });
        }
        for (int x = 0; x < 10; x++) {
            System.out.println(completionService.take().get());
        }
        service.shutdown();
    }
}
