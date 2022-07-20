package com.kenton.linkedlist;

import javax.swing.plaf.PanelUI;

/**
 * @author: Kenton
 * @description 管理英雄
 * @date: 2022/7/1 19:44
 */
public class SingleLinkedList {
    // 初始化一个头节点 头节点不动 不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单链表的最后
     * @param heroNode
     */
    public void addLast(HeroNode heroNode){
        // 因为头节点不能动 需要一个辅助遍历temp
        HeroNode temp = head;
        // 遍历链表 找到最后
        while (true){
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后 temp就后移
            temp = temp.next;
        }
        // 当退出while循环时 temp就指向链表的最后
        temp.next = heroNode;
    }

    // 显示链表
    public void listLinked(){
        // 判断链表是否为空
        if (head.next == null) {
            // 链表为空
            System.out.println("链表为空");
            return;
        }
        // 头节点固定 需要设置一直辅助变量temp
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp指针后移
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode heroNode){
        // 头节点不能动 使用辅助节点temp
        HeroNode temp = head;
        // 标志添加的编号是否存在 默认为false
        boolean flag = false;
        while (true) {
            // 说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // 位置找到 在temp的后面插入
            if (temp.next.no > heroNode.no) {
                break;
            }else if (temp.next.no == heroNode.no){
                // 要添加的节点已经存在
                flag = true;
                break;
            }
            // 后移
            temp = temp.next;
        }
        // 判断flag的值
        if (flag) {
            // flag为true不能添加 说明编号存在
            System.out.printf("插入的编号%d存在 不能加入\n",heroNode.no);
        }else {
            // 插入到链表中 temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据no编号修改
     * @param heroNode
     */
    public void updateMsg(HeroNode heroNode){
        // 因为头节点不存放数据 所以不需要判断head是不是要修改的节点
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空 无法修改");
            return;
        }
        // 定义是否找到标记
        Boolean flag = false;
        // 定义辅助变量temp
        HeroNode temp = head.next;
        // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                // 链表遍历结束
                break;
            }
            if (temp.no == heroNode.no) {
                // 找到要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            // 没有找到
            System.out.printf("没有找到编号为%d的节点",heroNode.no);
        }
    }

    /**
     * 删除节点
     * @param no
     */
    public void delPoint(int no){
        HeroNode temp = head;
        // 标志着是否找到待删除节点的前一节点
        Boolean flag = false;
        while (true) {
            // 说明遍历到链表的最后 退出
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                // 找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag
        if (flag) {
            // 可以删除
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的节点%d没有找到\n",no);
        }
    }

}
