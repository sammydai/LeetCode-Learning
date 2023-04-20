package com.learning;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo26 {
	public static void main(String[] args) throws Exception {
		System.out.println("准备聚会.....");
		DelayQueue<Member> queue = new DelayQueue<Member>();
		queue.add(new Member("张三", 3, TimeUnit.SECONDS));
		queue.add(new Member("李四", 5, TimeUnit.SECONDS));
		while (!queue.isEmpty()) { //如果聚会还有人在
			Delayed dyd = queue.poll(); //从里面取出数据内容
			//如果通过队列里面可以获得数据，就表示当前的用户已经离开了，满足了延迟条件
            System.out.println("【pool={"+dyd+"}】"+System.currentTimeMillis());
            TimeUnit.MILLISECONDS.sleep(500);
            
        }

    }
}

class Member implements Delayed{ //如果成员要想离开，一定要实现Delayed接口
    
    private String name; //聚会人员名单
    private long expire; //失效时间，人员离开的时间，毫秒单位
    private long delay; //设置的延迟时间

    public Member(String name, long delay,TimeUnit unit) {
        this.name = name;
        this.delay =TimeUnit.MILLISECONDS.convert(delay, unit); //保存延迟的时间 
        this.expire = System.currentTimeMillis()+this.delay;  //当前时间+延迟时间=失效时间
        
    }

    @Override
    public int compareTo(Delayed o) { //决定了优先级队列的弹出操作
         return (int)(this.delay-this.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public long getDelay(TimeUnit unit) { //计算延迟时间是否到达
        return unit.convert(this.expire-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return this.name + "预计" + this.delay+ " 离开，现在已经到点了。";
    }
    
}
