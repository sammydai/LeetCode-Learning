 package com.learning;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class JavaAPIDemo27 {
     public static void main(String[] args) {
        Random rand = new Random(); //利用这个类来模拟一个不同的交卷时间
        DelayQueue<Student> students = new DelayQueue<Student>();
        for (int x = 0; x < 45; x++) {
            int time = rand.nextInt(10);
            while (time<3) {
                time = rand.nextInt(10); //必须保证考试时间是大于3秒
            }
            students.put(new Student("学生- "+x, time, TimeUnit.SECONDS));
        }
        Teacher teacher = new Teacher(45, students);
        new Thread(teacher).start();
    }
}

class Teacher implements Runnable{ //老师也设置一个多线程

    private int studentCount = 0; //参与考试的学生数量
    private int submitCount = 0; // 保存交卷的学生个数
    private DelayQueue<Student> students = null;
    
    public Teacher(int studentCount, DelayQueue<Student> students) {
        this.studentCount = studentCount; //保存学生数量
        this.students = students; //保存所有的学生信息
    }


    @Override
    public void run() {
        System.out.println("*******同学们开始答题********");
        while (this.submitCount<this.studentCount) { //还有未交卷
            Student stu = this.students.poll();
            if (stu!=null) { //有人出队列了，有人交卷了
                stu.exam(); // 交卷处理
                this.submitCount++; //交卷的学生个数+1
            }
        }
        System.out.println("*******同学们结束考试********");    
    }
    
}

class Student implements Delayed{

    private String name;
    private long submitTime; // 学生交卷时间，使用毫秒单位
    private long workTime; // 实际的考试时间
    
    
    public Student(String name, long workTime, TimeUnit unit) {
        this.name = name;
        this.workTime = TimeUnit.MILLISECONDS.convert(workTime, unit);
        this.submitTime = System.currentTimeMillis()+this.workTime;
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(this.workTime-this.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public long getDelay(TimeUnit unit) {
         return unit.convert(this.submitTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public void exam() {
        System.out.println("【"+this.name+"交卷-{"+this.submitTime+"}】交卷时间： "+System.currentTimeMillis()+ "、花费时间： "+this.workTime);
    }
    
    @Override
    public String toString() {
        return "Student [name=" + name + ", submitTime=" + submitTime + ", workTime=" + workTime + "]";
    }
}