package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：结合转化类
 * thenCombine和上面的thenAcceptBoth方法有什么不同？
 *thenCombine方法用于在两个异步任务都完成后，将它们的结果合并，并使用BiFunction函数式接口对合并后的结果进行处理，并返回一个新的CompletableFuture。
 * thenAcceptBoth方法用于在两个异步任务都完成后，对它们的结果进行合并处理，但不返回新的结果。
 *
 */
public class ThenCombine {
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
                    SleepTools.second(2); // 模拟耗时2秒的操作
                    return "hello"; // 返回字符串 "hello"
                }).thenCombine(CompletableFuture.supplyAsync(() -> {
                    SleepTools.second(1); // 模拟耗时1秒的操作
                    return "world"; // 返回字符串 "world"
                }), (s1, s2) -> s1 + " " + s2) // 合并两个任务的结果，得到 "hello world"
                .join(); // 等待任务执行完成，并获取合并后的结果

        System.out.println(result); // 输出结果

    }
}
