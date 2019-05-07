 package com.learning;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import com.learning.Cache.Pair;

public class JavaAPIDemo28 {
    public static void main(String[] args) throws Exception {
        Cache<String,News> cache = new Cache<String,News>();
        cache.put("小明", new News("小明电影", "上映"), 3, TimeUnit.SECONDS);
        cache.put("小哄", new News("小哄五一", "放假"), 3, TimeUnit.SECONDS);
        System.out.println(cache.get("小明"));
        TimeUnit.SECONDS.sleep(5);
        System.out.println(cache.get("小明"));
        System.out.println(cache.get("小哄"));
        
    }
}

class Cache<K,V>{ // 定义缓存的操作类，该类之中需要用户设置保存的key类型与value类型
    //如果要实现多个线程的并发访问操作，必须要考虑使用ConcurrentHashMap子类
    private ConcurrentMap<K, V> cacheObject = new ConcurrentHashMap<K, V>();
    private DelayQueue<DelayItem<Pair>> delayQueue = new DelayQueue<DelayItem<Pair>>();
    class Pair { //定义一个内部类，该类可以保存队列之中的K与V类型
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    /**
     * 表示将要保存的数据写入到缓存之中，如果一个对象被重复保存了，则应该重置它的超过时间
     * @param key
     * @param value
     * @param time
     * @param unit
     */
    public void put(K key,V value,long time,TimeUnit unit) {
        // put()方法如果发现原本原本的key存在，则会用新的value替换掉旧的内容，同时返回旧的内容
        V oldValue = this.cacheObject.put(key, value); //将数据保存进去
        if (oldValue != null) { //原本已经存储过此内容了
            this.delayQueue.remove(key);
        }
        this.delayQueue.put(new DelayItem<Pair>(new Pair(key, value), time, unit));
    }
    
    public V get(K key) { //根据key获取内容
        return this.cacheObject.get(key); // Map负责查询
    }
    
    public Cache() { //如果想要清空不需要的缓冲数据，则需要守护线程
        Runnable daemonTask = () -> {
            while (true) { //守护线程要一直进行执行
                DelayItem<Cache<K, V>.Pair> item = Cache.this.delayQueue.poll(); //通过延迟队列获取数据
                if (item != null) { //已经有数据超时了
                    Pair pair = item.getItem();
                    Cache.this.cacheObject.remove(pair.key, pair.value);
                }
            }
        };
        Thread thread = new Thread(daemonTask,"缓存守护线程");
        thread.setDaemon(true); //设置守护线程
        thread.start(); //启动守护线程
    }
}

class DelayItem<T> implements Delayed{
    private T item;       // 设置要保存的数据内容
    private long delay;   // 保存缓存的时间
    private long expire;  // 设置缓存数据的失效时间
    
    
    public DelayItem(T item, long delay,TimeUnit unit) {
        this.item = item;
        this.delay = TimeUnit.MILLISECONDS.convert(delay, unit);
        this.expire = System.currentTimeMillis()+this.delay;
        
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(this.delay-this.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public long getDelay(TimeUnit unit) {
         return unit.convert(this.expire-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
    
    public T getItem() {
        return item;
    }
}

class News{ //定义一个新闻类
    private String title;
    private String note;
    
    public News(String title, String note) {
        this.title = title;
        this.note = note;
    }

    @Override
    public String toString() {
        return "【新闻数据】title=" + title + ", note=" + this.note;
    }
    
} 