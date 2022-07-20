package com.kenton;

import java.util.Arrays;

/**
 * @author: Kenton
 * @description
 * @date: 2022/7/8 14:25
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1,str2,next);
        System.out.println("index=" + index);
    }

    /**
     * KMP搜索方法
     * @param str1 源字符串
     * @param str2 字串
     * @param next 部分匹配表 是字串对应的部分匹配表
     * @return 如果是-1就是没有匹配到 否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        // 遍历
        for (int i = 0,j = 0; i < str1.length(); i++) {
            // 需要处理str1.charAt(i) != str2.charAt(j) 调整j的大小
            // KMP的核心点
            while (j > 0 && str1.charAt(i) != str2.charAt(i)){
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    // 获取一个字符串(字串)的部分匹配值表
    public static int[] kmpNext(String dest){
        // 创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        // 如果字符串的长度为1 部分匹配值为0
        next[0] = 0;
        for (int i = 0,j = 0; i < dest.length() ; i++) {
            // 当dest.charAt(i) != dest.chatAt(k) 我们需要从next[j-1]获取新的j
            // 同时满足 直到我们发现有 dest.charAt(i) == dest.chaAt(j)成立时才退出
            // 这是kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }
            // 当dest.charAt(i) == dest.charAt(k)满足时 部分匹配值就+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
