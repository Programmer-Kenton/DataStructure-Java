package com.kenton.linkedlist;

/**
 * @author: Kenton
 * @description 双向链表
 * @date: 2022/7/10 20:06
 */
public class DoubleHeroNode {
    private int no;
    private String name;
    private String nickName;
    // 指向下一个节点 默认为null
    private DoubleHeroNode next;
    // 指向前一个节点 默认为Null
    private DoubleHeroNode pre;

    public DoubleHeroNode() {
    }

    public DoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public DoubleHeroNode getNext() {
        return next;
    }

    public void setNext(DoubleHeroNode next) {
        this.next = next;
    }

    public DoubleHeroNode getPre() {
        return pre;
    }

    public void setPre(DoubleHeroNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}
