package com.example.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：消费类
 */
public class ThenAccept {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "hello") // 创建一个异步任务，返回结果 "hello"
                .thenAccept(s -> System.out.println(s + " world")); // 对任务结果进行处理，并输出 "hello world"

    }
}
