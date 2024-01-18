package com.yangfan.leetcode.datastructures.linkedlists;

import java.util.HashMap;

/**
 * 138.随机链表的复制
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 核心:
 * 1. 通过空间映射的方式节省了一个O(n)的hash表
 * 2. 链表的精细化操作，以及空指针情况的甄别和处理
 *
 */

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

public class Copy_List_with_Random_Pointer {

    public static void main(String[] args) {
        RandomNode head = generateRandomNode(5,1,20);
        printRandomNode(head);
        System.out.println("\n------复制后------");
        RandomNode copyHead = copyRandomList(head);
        printRandomNode(copyHead);
        System.out.println("\n" + (copyHead != head ? "复制成功" : "复制失败"));
    }


    /**
     * 利用相邻的位置关系，代替了hashmap的一一对应关系
     * 喵啊！
     * 三次遍历
     * 1. 将复制节点以追加的形式与原节点一一对应
     * 2. 设置复制节点的random节点
     * 3. 将链表分离成原链表和复制节点组成的链表
     *
     * 针线活练习大题
     */
    public static RandomNode copyRandomListPro(RandomNode head) {
        if(head == null) {
            return null;
        }
        RandomNode cur = head;
        RandomNode temp = null;  // 缝毛衣的针
        // copy node and link to every node
        // 1 -> 2
        // 1 -> 1'-> 2
        while(cur != null) {
            temp = cur.next;  // 先把原链表的next保存下
            cur.next = new RandomNode(cur.val); // 追加复制节点
            cur.next.next = temp; // 把原链表追加到复制节点后
            cur = temp; // 继续编织下一个节点
        }

        cur = head; // 归零，重新遍历
        RandomNode copy;
        // set copy node rand
        while(cur != null) {
            temp = cur.next.next; // 保存原节点的下一个原节点
            copy = cur.next; // 复制节点
            copy.random = cur.random != null ? cur.random.next : null; // 复制节点的random 即为原节点random节点 的复制节点
            cur = temp;  // 配合循环第一行，一次设置一对节点  n -> n'
        }

        // 也可简化为下面这样
//        while(cur != null) {
//            cur.next.random = cur.random != null ? cur.random.next : null;
//            cur = cur.next.next;
//        }

        cur = head; // 归，归零
        RandomNode res = head.next; // 用于返回
        // split 编织之前保存下一个原节点
        while(cur != null) {
            temp = cur.next.next; // 记录 1 -> 1' -> 2 的2节点
            copy = cur.next;
            cur.next = temp; // 断开了copy节点
            copy.next = temp != null ? temp.next : null; // 细节处理空指针，设置copy节点的next
            cur = temp; // 原链表下一个节点
        }

        // 也可以简化为下面这样(但没啥必要，就省了一行，可读性差了很多)
//        while(cur != null) {
//            copy = cur.next; // 保存1'
//            cur.next = cur.next.next;  // 1 -> 2
//            copy.next = cur.next != null ? cur.next.next : null; // 1' -> 2' or 1' -> null
//            cur = cur.next; // 从2开始
//        }

        return res;
    }

    /**
     * hashmap存储方式
     */
    public static RandomNode copyRandomList(RandomNode head) {
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode cur = head;
        while(cur != null) {
            map.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }
        // 归，归零
        cur = head;
        while(cur != null) {
            // cur 原链表
            // map.get(cur) 新链表
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    /***** ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓以下与题解无关***** ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓/

    /**
     * 每次调用都会生成一个随机链表
     * 节点数目是传入的，节点值是随机的范围是[min, max]。
     * 每个节点设置随机节点，随机节点可以是链表上的任意一个节点(不要局限于head节点)，也可以是null。
     */
    public static RandomNode generateRandomNode(int nodeNum, int min, int max) {
        RandomNode head = new RandomNode((int)(Math.random() * (max - min + 1)) + min);
        RandomNode cur = head;
        for(int i = 1; i < nodeNum; i++) {
            cur.next = new RandomNode((int)(Math.random() * (max - min + 1)) + min);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            cur.random = getRandomNode(head, nodeNum);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 随机获取一个节点
     */
    public static RandomNode getRandomNode(RandomNode head, int nodeNum) {
        if (head == null) {
            return null;
        }
        int random = (int) (Math.random() * nodeNum);
        RandomNode cur = head;
        while (random-- > 0) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 打印随机链表
     * 格式为：[节点1, 随机节点值] -> [节点2, 随机节点值] -> [节点3, 随机节点值] -> [节点4, 随机节点值]
     * 每个箭头后的节点为原节点的next节点
     * 最后一个节点后不要有箭头
     */
    public static void printRandomNode(RandomNode head) {
        RandomNode cur = head;
        while(cur != null) {
            System.out.print("[" + cur.val + ", " + (cur.random == null ? "null" : cur.random.val) + "]");
            if(cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
    }







}



