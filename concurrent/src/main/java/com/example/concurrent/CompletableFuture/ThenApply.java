package com.example.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：变换类
 */
public class ThenApply {
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> "hello") // 创建一个异步任务，返回结果 "hello"
                .thenApply(s -> s + " world") // 对任务结果进行处理，并返回新的结果 "hello world"
                .join(); // 等待任务执行完成，并获取结果

        System.out.println(result); // 输出结果

    }
}
