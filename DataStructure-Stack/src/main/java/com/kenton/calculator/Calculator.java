package com.kenton.calculator;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/20 15:27
 */
public class Calculator {
    public static void main(String[] args) {
        // 计算表达式
        String expression = "3+2*6-2";
        // 创建数栈和符号栈
        ArrayStackCalculator numStack = new ArrayStackCalculator(10);
        ArrayStackCalculator operStack = new ArrayStackCalculator(10);
        // 定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int result = 0; // 用于扫描的指针
        // 将每次扫描得到的保存到ch
        char ch = ' ';
        // 拼接多位数的字符串
        String keepNum = "";
        // while循环的扫描expression
        while (true) {
            // 依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么 然后做响应的处理
            // 如果是运算符
            if (operStack.isOper(ch)) {
                // 判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    // 如果符号栈有操作符 就进行比较 如果当前操作符的优先级小于等于栈中的操作符 就需要从数栈中pop两个数字
                    // 在符号栈中pop出一个符号 进行运算 将得到结果 入数栈 然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        result = numStack.cal(num1, num2, oper);
                        // 运算的结果入数栈
                        numStack.push(result);
                        // 将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符的优先级大于栈中的操作符 就直接入符号栈
                        operStack.push(ch);
                    }
                } else {
                    // 如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else {
                // 如果是数字 直接入数栈 ch的char类型 减去0代表的48ASCII码值 得到的即为要表达的数字
                // numStack.push(ch - 48);
                // 处理多位数 在处理数字时需要向expression的表达式后面再看几位 如果是数就扫描 如果是符号就入栈
                // 定义字符串变量用于拼接
                keepNum += ch;

                // 如果ch已经是expression的最后一位则直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 判断下一个字符是否为数字 若是就继续扫描 否则直接入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是运算符 则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        // keepNum清空
                        keepNum = "";
                    }
                }
                // Index + 1 并判断是否扫描到expression的最后
                index++;
                if (index >= expression.length()) {
                    break;
                }
            }

            // 当表达式扫描完毕 就顺序的从数栈和符号栈中pop出相应的数和符号 并运行
            while (true) {
                // 如果符号栈为空 则计算到最后结果 数栈中只能有一个数字
                if (operStack.isEmpty()) {
                    break;
                }
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                result = numStack.cal(num1, num2, oper);
                // 最终的结果入栈
                numStack.push(result);
            }
            // 将数栈最后的数字 也就是运算结果Pop出来
            System.out.printf("表达式的%s=%d", expression, numStack.pop());
        }
    }
}