package com.kenton.stack;

import java.util.Scanner;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/20 15:26
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        while(loop) {
            System.out.println("show:显示栈");
            System.out.println("exit:退出栈");
            System.out.println("push:添加数到栈");
            System.out.println("pop:从栈顶取出数据");
            System.out.println("list:遍历栈");
            System.out.println("请输入你的选择");
            switch (sc.next()) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);
                    } catch (Exception var9) {
                        System.out.println(var9.getMessage());
                    }
                    break;
                case "exit":
                    sc.close();
                    loop = false;
            }
        }

        System.out.println("程序退出~~~");
    }
}
