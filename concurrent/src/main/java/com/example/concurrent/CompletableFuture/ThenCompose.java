package com.example.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 类说明：结合转化类
 *
 * 说明：
 * 使用thenCompose方法对异步任务的结果进行链式处理。thenCompose方法接受一个Function函数式接口作为参数，该接口的输入参数为上一个任务的结果（这里是10），返回参数为一个新的CompletionStage。在这个示例中，我们使用Lambda表达式来处理结果，将上一个任务的结果加1并返回一个新的CompletionStage。
 * 由于thenCompose方法返回一个新的CompletionStage，我们使用join()方法等待任务的执行完成，并获取最终的结果。最终结果是 10 + 1 = 11。
 */
public class ThenCompose {
    public static void main(String[] args) {
        Integer result = CompletableFuture.supplyAsync(() -> {
            return 10; // 返回整数值 10
        }).thenCompose(i -> CompletableFuture.supplyAsync(() -> {
            return i + 1; // 对上一个任务的结果进行处理，返回整数值 i+1
        })).join(); // 等待任务执行完成，并获取最终的结果

        System.out.println(result); // 输出结果

    }
}
