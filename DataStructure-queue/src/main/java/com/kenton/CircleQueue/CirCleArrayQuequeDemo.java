package com.kenton.CircleQueue;

import java.util.Scanner;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/30 15:13
 */
public class CirCleArrayQuequeDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("s(show):显示菜单");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            // 接收一个字符
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是:%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
