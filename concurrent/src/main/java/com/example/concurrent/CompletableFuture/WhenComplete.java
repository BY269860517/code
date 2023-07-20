package com.example.concurrent.CompletableFuture;


import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：运行后记录结果类
 * 说明：
 * 在实际应用中，使用whenComplete和exceptionally方法可以有效处理异步任务中的结果和异常情况，为异步任务提供备用的默认结果，并在需要时进行相应的处理。这样可以提高代码的健壮性和容错性。
 */
public class WhenComplete {
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
            SleepTools.second(1); // 模拟耗时1秒的操作
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况"); // 模拟抛出异常
            }
            return "s1"; // 这里实际上不会执行，因为上面的异常已经抛出
        }).whenComplete((s, t) -> {
            System.out.println(s); // 正常情况下输出结果 "s1"
            System.out.println(t.getMessage()); // 异常情况下输出异常信息 "测试一下异常情况"
        }).exceptionally(e -> {
            System.out.println(e.getMessage()); // 异常处理，输出异常信息
            return "hello world"; // 异常情况下的默认返回结果
        }).join(); // 等待任务执行完成，并获取结果

        System.out.println(result); // 输出结果

    }
}
