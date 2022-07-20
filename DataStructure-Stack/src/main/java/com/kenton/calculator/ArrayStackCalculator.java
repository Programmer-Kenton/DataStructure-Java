package com.kenton.calculator;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/20 15:03
 */
public class ArrayStackCalculator {

    // 栈的大小
    private int maxSize;

    // 数组模拟栈 数据放在数组中
    private int[] stack;

    // top表示栈顶 初始化为-1
    private int top = -1;

    // 构造器
    public ArrayStackCalculator(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 查看栈顶的值
    public int peek(){
        return stack[top];
    }

    // 栈满
    public boolean isFull(){
        return top == maxSize;
    }

    // 栈空
    public boolean isEmpty(){
        return top == -1;
    }

    // 入栈
    public void push(int value){
        // 判断是否栈满
        if (isFull()){
            System.out.println("Stack is full...");
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
            throw new RuntimeException("栈空 无法弹出");
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

    /**
     * 返回运算符的优先级 优先级判定谷规则由程序员确定 优先级使用数字表示
     * 数字越大则优先级越高
     */
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            // 假定是加减乘除的运算 不包含其他
            return -1;
        }
    }

    // 判断是否为运算符
    public boolean isOper(int val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法 num2先压入栈中 再是num1压入栈中 所以弹出顺序是num1-->num2
    public int cal(int num1,int num2,int oper){
        // result存放计算的结果
        int result = 0;
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                // 先压入的数字作为被减数
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}
