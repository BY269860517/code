package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：通过exceptionally进行补偿。
 */
public class Exceptionally {
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1); // 模拟耗时1秒的操作
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况"); // 模拟抛出异常
            }
            return "s1"; // 这里实际上不会执行，因为上面的异常已经抛出
        }).exceptionally(e -> {
            System.out.println(e.getMessage()); // 异常处理，输出异常信息
            return "hello world"; // 异常情况下的默认返回结果
        }).join(); // 等待任务执行完成

        System.out.println(result); // 输出结果
    }
    }
