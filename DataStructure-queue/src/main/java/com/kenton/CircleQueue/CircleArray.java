package com.kenton.CircleQueue;

/**
 * @author: Kenton
 * @description 循环队列
 * @date: 2022/6/30 15:14
 */

/**
 * 循环队列思路如下:
 * 1.front变量的含义做一个调整:front就指向队列的第一个元素 也就是说arr[front]就是队列的第一个元素
 * front和rear的初始值不再是-1 而是0
 * 2.rear变量的含义做一个调整:rear指向队列的最后一个元素的后一个位置 因为希望空出一个空间作为约定
 * 3.当队列满时 条件是(rear+1)%maxSize=front [满]
 * 4.当队列为空的条件 rear=front
 * 5.队列中有效的数据个数(rear+maxSize-front)%maxSize
 */
public class CircleArray {
    // 表示数组的最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 存放数据 模拟队列
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = rear = 0;
    }

    // 判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满 不能添加数据");
            return;
        }
        // 直接加入数据
        arr[rear] = n;
        // 将rear后移 并且考虑rear的取模
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据 出队列
    public int getQueue(){
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空 不能取数据");
        }
        /** 分析front是指向队列的第一个元素
         * 1.先把front对应的值保存到一个临时变量
         * 2.将front后移 考虑取模
         * 3.将临时保存的变量返回
         */
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空没有数据");
            return;
        }
        for (int i = front;i < front + useSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列的有效数据个数
    public int useSize(){
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头元素 注意不是取出
    public int headQueue(){
        // 判断是否空
        if (isEmpty()) {
            throw new RuntimeException("队列空 没有数据");
        }
        return arr[front];
    }
}
