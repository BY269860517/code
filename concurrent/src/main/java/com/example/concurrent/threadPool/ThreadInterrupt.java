package com.example.concurrent.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * interrupt中断机制
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();  // 启动线程

        try {
            Thread.sleep(2000);  // 主线程休眠2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();  // 中断线程


    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Thread is running");
                    Thread.sleep(500);  // 线程休眠500毫秒
                } catch (InterruptedException e) {
                    // 捕获InterruptedException异常，退出线程
                    System.out.println("Thread is interrupted");
                    return;
                }
            }
        }}

}
