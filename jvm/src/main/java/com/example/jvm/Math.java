package com.example.jvm;

/**
 * @Auther: by
 * @Date: 2021/6/18 17:36
 * @Description: 用来研究jvm的内存模型
 */
public class Math {
    public static final int initData = 666;
    public static User user = new User();

    public int compute() {  //一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
        new Thread().start();
    }

}
