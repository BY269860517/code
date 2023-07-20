package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：取两个异步最快消费类
 * 方法：.acceptEither(CompletableFuture, (s) -> System.out.println(s))：使用acceptEither方法，接受两个异步任务的任意一个完成的结果，如果其中一个任务完成了，将其结果作为参数传递给Lambda表达式(s) -> System.out.println(s)并在主线程中打印结果。注意，这里的Lambda表达式中的s参数表示第一个完成的结果。
 * 当需要取三个结果的时候：.anyOf(CompletableFuture, CompletableFuture, CompletableFuture)
 */
public class AcceptEither {
    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2);
            return "s1";
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1);
            return "hello world";
        }), (s) -> System.out.println(s));
        SleepTools.second(3);
    }
}
