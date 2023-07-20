package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：运行后执行类
 * 不关心这两个 CompletionStage 的结果，只关心这两个 CompletionStage 都执
 * 行完毕，之后再进行操作（Runnable）。
 */
public class RunAfterBoth {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1);
            return "s1";
        }).runAfterBothAsync(CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2);
            return "s2";
        }), () -> System.out.println("hello world"));
        SleepTools.second(3);
    }
}
