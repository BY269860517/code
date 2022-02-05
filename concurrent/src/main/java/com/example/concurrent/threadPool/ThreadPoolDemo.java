package com.example.concurrent.threadPool;


import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();//快 最大线程去干活，可以线程复用，一个线程可能做多个活 SynchronousQueue：同步队列
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);//慢  创建10个线程去干活
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();//最慢 只用一个线程干活

        RejectedExecutionHandler rejectedExecutionHandler=  new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                // 写数据库的代码
                System.out.println("自定义拒绝策略：写数据库的代码");
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10),new MonkeyRejectedExecutionHandler());//自定义线程

        for (int i = 1; i <= 100; i++) {
            executorService3.execute(new MyTask(i));

        }
    }
}

/***
 * 项目
 */
class MyTask implements Runnable {
    int i = 0;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "程序员做第" + i + "个项目");
        try {
            Thread.sleep(3000L);//业务逻辑
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
