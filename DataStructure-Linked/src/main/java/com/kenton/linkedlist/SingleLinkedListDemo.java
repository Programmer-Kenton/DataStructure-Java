package com.kenton.linkedlist;

import java.util.Stack;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/1 19:41
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroOne = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroTwo = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroThree = new HeroNode(3, "吴用", "智多星");
        HeroNode heroFour = new HeroNode(4, "林冲", "猫仔头");

        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 元素加入节点尾部
        /*singleLinkedList.addLast(heroOne);
        singleLinkedList.addLast(heroTwo);
        singleLinkedList.addLast(heroThree);
        singleLinkedList.addLast(heroFour);*/

        // 按照编号链表添加元素
        singleLinkedList.addByOrder(heroOne);
        singleLinkedList.addByOrder(heroFour);
        singleLinkedList.addByOrder(heroTwo);
        singleLinkedList.addByOrder(heroThree);
        singleLinkedList.addByOrder(heroThree);


        System.out.println("-------------------------------------------------------------------------");
        System.out.println("测试链表反转");
        System.out.println("原来的链表情况~");
        singleLinkedList.listLinked();
        System.out.println("反转后的链表情况~");
        reverseList(singleLinkedList.getHead());



        System.out.println("-------------------------------------------------------------------------");
        System.out.println("测试栈结构倒取链表元素");
        reversePrint(singleLinkedList.getHead());


        System.out.println("-------------------------------------------------------------------------");
        System.out.println("显示修改之前的链表");
        // 显示修改之前的链表
        singleLinkedList.listLinked();

        // 测试修改节点
        HeroNode heroNode = new HeroNode(2, "小卢", "火麒麟");
        singleLinkedList.updateMsg(heroNode);

        System.out.println("-------------------------------------------------------------------------");
        // 遍历显示修改后的链表
        singleLinkedList.listLinked();

        System.out.println("-------------------------------------------------------------------------");
        // 删除一个节点
        singleLinkedList.delPoint(1);
        System.out.println("修改后的链表情况~~~");
        singleLinkedList.listLinked();

        System.out.println("----测试单链表有效节点的个数----");
        System.out.println(getPointNums(singleLinkedList.getHead()));

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("测试倒数第K个节点");
        HeroNode res = findIndex(singleLinkedList.getHead(), 1);
        System.out.println("res="+res);


    }


    /**
     * 将链表反转
     */
    public static void reverseList(HeroNode head){
        // 如果当前链表为空 或者只有一个节点 无需反转 直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义辅助指针
        HeroNode temp = head.next;
        // 定义一个临时变量next 用于指向当前节点的[temp]的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表 每遍历一个节点就取出 放在新的链表reverseHead的前端
        // 如果temp为空 说明遍历结束了
        while (temp != null){
            // 先暂时保存当前节点的下一个节点
            next = temp.next;
            // 将temp的下一个节点指向新的链表的最前端
            temp.next = reverseHead.next;
            // 将temp连接到新的链表上
            reverseHead.next = temp;
            // 让temp后移
            temp = next;
        }
        // 将head.next指向reverseHead.next 实现单链表的反转
        head.next = reverseHead.next;
    }


    /**
     * 获取单链表节点的个数 (如果是带头节点的链表 需求不统计头节点)
     * @param head 链表的头节点
     * @return 返回的是有效节点的个数
     */
    public static int getPointNums(HeroNode head){
        if (head.next == null) {
            // 空链表
            return 0;
        }
        int length = 0;
        // 定义辅助变量 没有统计头节点
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找单链表中倒数第k个节点
     * 1.编写一个方法 接收head节点 同时接收index节点 即倒数第index节点
     * 2.先把链表从头到尾遍历 得到链表的总长度getLength
     * 3.得到size后 把链表的第一个开始遍历(size-index)就可以得到倒数第index的节点
     * 4.如果找到了 返回该节点否则返回Null
     */
    public static HeroNode findIndex(HeroNode heroNode,int index){
        // 链表为空 返回Null
        if (heroNode.next == null) {
            return null;
        }
        // 第一次遍历得到链表的长度
        int size = getPointNums(heroNode);
        // 第二次遍历 size-index位置 就是倒数第k个节点
        // index的校验
        if (index <= 0 || index > size) {
            System.out.println("倒数位置 不合法");
            return null;
        }
        // 定义辅助变量
        HeroNode temp = heroNode.next;
        // for循环定位到倒数的index
        for (int i = 0; i < size - index; i++) {
            heroNode = heroNode.next;
        }
        return heroNode;
    }

    /**
     * 利用栈结构实现链表逆序打印
     */
    public static void reversePrint(HeroNode head){
        if (head.next == null) {
            // 空链表无法打印
            return;
        }
        // 创建一个栈 将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        // 将链表的所有节点压入栈中
        while (temp != null) {
            stack.push(temp);
            // 指针后移
            temp = temp.next;
        }
        // 将栈中的节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
