package com.kenton;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/13 13:59
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        // 加入5个节点
        circleSingleLinkedList.addBoy(125);
        circleSingleLinkedList.showBoy();

        // 测试出圈
        circleSingleLinkedList.countBoy(10,20,125);
    }
}
