package com.example.concurrent.lock;

import java.util.concurrent.CountDownLatch;
/**
 * @Author by
 * @Description  让多个线程等待：模拟并发，让并发线程一起执行
 * @Date 11:03 2022/2/21
 * @Param
 * @return
**/
public class CountDownLatchTest {
    
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    //准备完毕……运动员都阻塞在这，等待号令
                    System.out.println(  Thread.currentThread().getName()+"运动员……阻塞");
                    countDownLatch.await();
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(parter + "开始执行……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(2000);// 裁判准备发令
        System.out.println("裁判发令");
        countDownLatch.countDown();// 发令枪：执行发令
    }}