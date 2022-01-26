package com.example.concurrent.jmm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: by
 * @Date: 2022/1/25 08:59
 * @Description:1
 */
public class ListTest {
    public static void main(String[] args) {
        int [] i={1,2,6};
        List list= new ArrayList();
        System.out.println(3*1.5);
        System.out.println(3+(3 >>1));
    }
}
