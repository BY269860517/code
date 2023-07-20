package com.example.concurrent.threadPool;

import java.util.concurrent.*;

public class ThreadDemo {

    private String name;

    public ThreadDemo(String name) {

        this.name = name;
    }

    /**
     * @Description:使用继承方式创建线程
     * @Param:
     * @return:
     * @Author: Mr.Pan
     * @Date:
     */
    public class myThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--" + name);
        }
    }

    /**
     * @Description: 使用runable的方式创建线程
     * @Param:
     * @return:
     * @Author: Mr.Pan
     * @Date:
     */
    public class myRunable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--" + name + "使用runable的方式创建线程");
        }
    }

    /**
     * @Description: 使用callable的方式创建线程
     * @Param:
     * @return:
     * @Author: Mr.Pan
     * @Date:
     */
    public class myCallable implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "--" + name + "使用Callable的方式创建线程");
           // System.out.println(1/0);
            return "OK";
        }
    }
    public static void main(String[] args) {
        //继承的方式
        // new ThreadDemo("monkey老师").run();
//        myThread myThread = new ThreadDemo("monkey老师").new myThread();
//        // myThread.start();
//        myThread.run();

        //runable接口的方式
//        myRunable myru = new ThreadDemo("monkey老师").new myRunable();
//        Thread thread = new Thread(myru);
//        thread.start();
//

        //callable的方式并得到执行结果
        myCallable myCallable=new ThreadDemo("monkey老师").new myCallable();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
       //submit方法会返回一个Future对象，通过这个Future对象可以判断任务是否执行成功，如果执行成功则可以通过Future的get方法获取返回值
        //excuter方法没有返回值
        Future<String> submit = executor.submit(myCallable);

        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }finally {
            executor.shutdown();
        }


    }

}
