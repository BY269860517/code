package com.example.concurrent.jmm;

import java.awt.image.ImageProducer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: by
 * @Date: 2022/2/13 11:27
 * @Description:
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map mp =new ConcurrentHashMap();
        mp.put("ss",232);
    }
}
