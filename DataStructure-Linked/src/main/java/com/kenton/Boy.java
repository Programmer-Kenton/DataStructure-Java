package com.kenton;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/13 13:59
 */
public class Boy {
    // 编号
    private int no;

    // 指向下一个节点 默认Null
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
