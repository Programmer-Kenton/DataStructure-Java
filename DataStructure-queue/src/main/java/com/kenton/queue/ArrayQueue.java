package com.kenton.queue;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/30 12:43
 */

// 数组模拟普通队列
public class ArrayQueue {
    // 表示数组的最大容量
    private int maxSize;
    // 指向队列的头部
    private int front;
    // 指向队列的尾部
    private int rear;
    // 该数组用于存放数据 模拟队列
    private int[] arr;

    // 创建队列的构造器

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 指向队列头部 分析出初始化时front是指向队列头(0)的前一个位置
        front = -1;
        // 指向队列尾 指向队列尾的数据 刚开始两个指针在同一个位置
        rear = -1;
    }

    // 判断队列是否满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        // 判断队列是否满
        if (isFull()){
            System.out.println("队列已满 无法加入");
            return;
        }
        // 让rear后移
        rear++;
        arr[rear] = n;
    }

    // 获取队列的数据 出队列
    public int getQueue(){
        // 判断队列是否空
        if (isEmpty()){
            throw new RuntimeException("队列空 不能取数据");
        }
        // front后移
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue(){
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空 没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d",i,arr[i]);
        }
    }
    // 显示队列的头数据 注意不是取出数据
    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列空 没有数据");
        }
        // front+1的原因是 front一开始是指向队列头的前一个位置
        return arr[front+1];
    }
}
