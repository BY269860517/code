package com.example.concurrent.jmm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: by
 * @Date: 2022/2/12 23:13
 * @Description:
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map map =new HashMap();
        map.put("name","zhangsan");

        System.out.println(1 << 4);
    }
}
