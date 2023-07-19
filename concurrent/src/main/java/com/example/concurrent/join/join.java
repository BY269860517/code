/**
 * @program: concurrent
 * @description: 三个线程顺序运行
 * @author: Mr.Pan
 * @create: 2023-07-15 22:06
 **/
package com.example.concurrent.join;

public class join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1——我是第一个执行");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2-我是第二个执行");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("thread3-我是第三个执行");
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }

}