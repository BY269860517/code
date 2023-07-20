package com.example.concurrent.syn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author  Fox
 */
@Slf4j
public class SyncWaitTest {

    private Object lock = new Object();

    public void test() {
        log.debug(Thread.currentThread().getName()+" start");
        synchronized (lock){
            log.debug(Thread.currentThread().getName()+" execute");
            try {
                //Thread.sleep(5000);
                lock.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug(Thread.currentThread().getName()+" end");
        }

    }



    public static void main(String[] args) {
        SyncWaitTest test = new SyncWaitTest();

        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.test();
                }
            },"thread"+i).start();
        }

    }


}
