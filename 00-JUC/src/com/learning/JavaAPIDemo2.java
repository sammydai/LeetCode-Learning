 package com.learning;

public class JavaAPIDemo2 {
    public static void main(String[] args) {
        for (int x = 0; x < 2; x++) {
            new Thread(()->{ 
               System.out.println("【"+Thread.currentThread().getName()+"】线程应用执行完毕。"); 
            },"线程对象-"+x).start();
        }
        System.out.println("【*****主线程*****】人齐了，大巴车开走了。");
    }

}
