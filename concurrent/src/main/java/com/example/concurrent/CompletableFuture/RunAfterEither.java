package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：取最快运行后执行类
 * 两个 CompletionStage，谁计算的快，我就用那个 CompletionStage 的结果进
 * 行下一步的消费操作。
 */
public class RunAfterEither {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2);
            return "s1";
        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1);
            return "s2";
        }), () -> System.out.println("hello world"));
        SleepTools.second(3);
    }
}
