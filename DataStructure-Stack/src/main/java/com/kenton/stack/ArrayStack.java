package com.kenton.stack;

/**
 * @author: Kenton
 * @description 栈类
 * @date: 2022/7/16 14:27
 */
public class ArrayStack {

    // 栈的大小
    private int maxSize;

    // 数组模拟栈 数据放在数组中
    private int[] stack;

    // top表示栈顶 初始化为-1
    private int top = -1;

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty(){
        return top == -1;
    }

    // 入栈
    public void push(int value){
        // 判断是否栈满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop(){
        // 判断栈是否空
        if (isEmpty()){
            // 抛出异常
            throw new RuntimeException("栈空 无法弹出数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈 从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }

        for (int i = top;i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
