package com.example.concurrent.test;

/**
 * @Auther: by
 * @Date: 2022/4/19 10:58
 * @Description:
 *
 * 1.打印9*9乘法表
 *要求：标准的9*9
 *要求对齐，各位十位对齐
 * 代码质量
 *
 */
public class Test1 {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            System.out.println(i);
            for (int j=1;j<i;j++){
                System.out.println(i+"*"+j+"="+i*j);
            }
        }
    }
}
