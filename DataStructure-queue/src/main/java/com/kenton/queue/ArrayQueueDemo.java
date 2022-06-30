package com.kenton.queue;

import java.util.Scanner;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/30 12:43
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        // 接收用户的输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        // 输出菜单
        while (flag){
            System.out.println("s(show):显示菜单");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是:%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
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
