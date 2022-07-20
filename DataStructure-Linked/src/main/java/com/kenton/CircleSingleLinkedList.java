package com.kenton;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/13 14:01
 */
public class CircleSingleLinkedList {

    // 创建一个first节点 当前没有编号
    private Boy first = null;

    // 添加小孩 构建一个环形链表
    public void  addBoy(int nums){
        // 先对Nums做数据校验
        if (nums < 1) {
            System.out.println("num的值不正确");
            return;
        }

        // 辅助指针 帮构建环形链表
        Boy curBoy = null;
        // 使用for循环来创建环形链表
        for (int i = 1;i <= nums;i++){
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1){
                first = boy;
                // 构成环状
                first.setNext(first);
                // 让curBoy指向第一个小孩
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // 遍历当前的环形链表
    public void showBoy(){
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为first节点不能动 因此使用辅助指针完成遍历
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if (curBoy.getNext() == first) {
                // 已经遍历完毕
                break;
            }
            // curBoy后移
            curBoy = curBoy.getNext();
        }
    }

    // 根据用户的输入计算出圈的顺序

    /**
     *
     * @param startNo 表示从第几个节点开始数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少给节点在约瑟夫环中
     */
    public void countBoy(int startNo,int countNum,int nums){
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有错误");
            return;
        }
        // 创建辅助指针 帮助节点出圈
        Boy helper = first;
        // helper辅助指针 事先应该指向环形链表的最后这个节点
        while (true){
            if (helper.getNext() == first) {
                // 说明helper指向最后的节点
                break;
            }
            helper = helper.getNext();
        }
        // 报数前 让first和helper移动k-1次
        for (int j = 0;j < startNo - 1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当节点报数时 让first和helper指针同时移动m-1次 然后出圈
        // 这里是循环操作 直到圈中只有一个节点
        while (true){
            if (helper == first) {
                // 说明圈中只有一个节点
                break;
            }
            // 让first和helper指针同时移动countNum-1
            for(int j = 0;j < countNum - 1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这是first指向的节点就是要出圈的节点
            System.out.printf("小孩%d出圈",first.getNo());
            // 把first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的节点编码%d\n",first.getNo());
    }
}
