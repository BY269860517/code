package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：结合消费类，将两个结果合并消费
 * 我们使用thenAcceptBoth方法来处理这两个异步任务的结果。thenAcceptBoth方法接受两个CompletionStage和一个BiConsumer函数式接口作为参数。在这个示例中，我们使用Lambda表达式来指定要执行的操作，将两个任务的结果合并为一个字符串，并输出结果 "hello world"。
 */
public class ThenAcceptBoth {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1); // 模拟耗时1秒的操作
            return "hello"; // 返回字符串 "hello"
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2); // 模拟耗时2秒的操作
            return "world"; // 返回字符串 "world"
        }), (s1, s2) -> System.out.println(s1 + " " + s2)); // 在两个任务都完成后处理结果

        SleepTools.second(3); // 主线程休眠3秒
    }
}
