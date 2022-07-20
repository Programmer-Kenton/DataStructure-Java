package com.kenton.linkedlist;

/**
 * @author: Kenton
 * @description 双向链表启动类
 * @date: 2022/7/10 20:04
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("测试双向链表");
        DoubleHeroNode heroOne = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode heroTwo = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode heroThree = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode heroFour = new DoubleHeroNode(4, "林冲", "猫仔头");

        // 创建双向链表管理对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroOne);
        doubleLinkedList.add(heroTwo);
        doubleLinkedList.add(heroThree);
        doubleLinkedList.add(heroFour);

        doubleLinkedList.listLinked();

        // 修改节点
        DoubleHeroNode newHeroNode = new DoubleHeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        doubleLinkedList.listLinked();

        // 删除链表节点
        doubleLinkedList.deletePoint(3);
        System.out.println("删除后的链表");
        doubleLinkedList.listLinked();

        // 删除链表的最后节点
        doubleLinkedList.deletePoint(4);
        System.out.println("删除链表的最后节点");
        doubleLinkedList.listLinked();
    }
}
