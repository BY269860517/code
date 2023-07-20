package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：取最快转换类
 * 根据需求来选择使用acceptEither还是applyToEither方法。如果您只需要消费结果而不需要返回新的结果，则可以使用acceptEither方法。如果您需要对结果进行处理，并且需要返回新的结果，那么可以使用applyToEither方法
 */
public class ApplyToEither {
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1);
            return "s1";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2);
            return "hello world";
        }), s -> s).join();
        System.out.println(result);
    }
}
