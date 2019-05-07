 package com.learning;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo4 {
    public static void main(String[] args) throws Exception {
        Exchanger<String> exc = new Exchanger<String>(); //准备出一个交换空间
        for (int x = 0; x < 3; x++) { //定义三个消费者
            new Thread(()->{
                while (true) {
                    try {
                        String data  = exc.exchange(null);
                        TimeUnit.SECONDS.sleep(2);
                        if (data!=null) { // 现在取得了生产者的数据
                            System.out.println("【"+Thread.currentThread().getName()+"】消费了数据 "+data);
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                    }
                }
            },"消费者-"+x).start();
        }
        
        for (int x = 0; x < 2; x++) { //定义两个生产者
            int temp = x;
            new Thread(()->{
                for (int y = 0; y < 2; y++) { //一共生产4个数据
                    String data  = "MMM - "+temp+" - "+y;
                    try {
                        TimeUnit.SECONDS.sleep(2); //让生产者放慢节奏
                        exc.exchange(data); //将生产的数据保存在交换空间
                        System.out.println("【"+Thread.currentThread().getName()+"】生产了数据 "+ data);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                    } 
                }
            },"生产者-"+x).start();
        }
    }
     
}
