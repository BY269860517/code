package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：执行操作类
 *对上一步的计算结果不关心，执行下一个操作，入参是一个 Runnable 的实
 * 例，表示上一步完成后执行的操作。
 */
public class ThenRun {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1);
            return "hello";
        }).thenRun(() ->{
            System.out.println("hello world");
        } );
        SleepTools.second(2);
    }
}
