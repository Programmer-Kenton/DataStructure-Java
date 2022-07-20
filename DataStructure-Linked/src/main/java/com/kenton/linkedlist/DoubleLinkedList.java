package com.kenton.linkedlist;

/**
 * @author: Kenton
 * @description 管理双向链表类
 * @date: 2022/7/10 20:04
 */
public class DoubleLinkedList {
    // 初始化一个头节点 头节点不要动 不存放具体的数据
    private DoubleHeroNode head = new DoubleHeroNode(0,"","");

    // 返回头节点
    public DoubleHeroNode getHead() {
        return head;
    }

    // 遍历双向链表的方法
    public void listLinked(){
        // 判断链表是否为空
        if (head.getNext() == null) {
            // 链表为空
            System.out.println("链表为空");
            return;
        }
        // 头节点固定 需要设置一直辅助变量temp
        DoubleHeroNode temp = head.getNext();
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp指针后移
            temp = temp.getNext();
        }
    }

    // 添加节点到双链表
    public void add(DoubleHeroNode doubleHeroNode){
        // 头节点不能动 我们需要一个辅助遍历temp
        DoubleHeroNode temp = head;
        // 遍历链找到最后
        while (true) {
            // 找到链表的最后
            if (temp.getNext() == null) {
                break;
            }
            // 如果没有找到最后 将temp后移
            temp = temp.getNext();
        }
        // 当退出while循环时 temp就指向链表的最后
        // 形成双向链表
        temp.setNext(doubleHeroNode);
        doubleHeroNode.setPre(temp);
    }

    // 修改一个节点的内容
    public void update(DoubleHeroNode newDoubleHeroNode){
        // 判断是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点 根据no编号
        DoubleHeroNode temp = head.getNext();
        // 表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 已经遍历结束
                break;
            }
            if (temp.getNo() == newDoubleHeroNode.getNo()) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        // 根据flag判断是否找到要修改的节点
        if (flag){
            temp.setName(newDoubleHeroNode.getName());
            temp.setNickName(newDoubleHeroNode.getNickName());
        }else {
            // 没有找到
            System.out.printf("没有找到编号%d的节点,不能修改\n",newDoubleHeroNode.getNo());
        }
    }

    // 删除双联链表的节点
    // 对于双向链表可以直接找到要删除的节点 而不需要找到要删除节点的前一个节点
    public void deletePoint(int no){
        // 判断当前链表是否为空
        if (head.getName() == null) {
            // 空链表
            System.out.println("链表为空 无法删除");
            return;
        }
        // 定义辅助指针 直接把头节点之后的节点赋值给辅助指针
        DoubleHeroNode temp = head.getNext();
        // 标志是否找到待删除的节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 已经到链表的最后
                break;
            }
            if (temp.getNo() == no) {
                // 已经找到要删除的节点
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        // 判断flag
        if (flag) {
            // 可以删除
            temp.getPre().setNext(temp.getNext());
            // 如果是最后一个节点就不需要执行下面这句代码 否则出现空指针异常 temp.getNext()为空
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
}
