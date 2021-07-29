package com.example.jvm;

/**
 * @Auther: by
 * @Date: 2021/7/2 11:23
 * @Description:运行此代码，cpu会飙高
 */
public class CpuTop {
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
        while (true){
            math.compute();
        }
    }
}
