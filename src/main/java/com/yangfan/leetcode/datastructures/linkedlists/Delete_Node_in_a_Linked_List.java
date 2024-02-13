package com.yangfan.leetcode.datastructures.linkedlists;

import com.yangfan.dataobject.ListNode;

/**
 * 237. Delete Node in a Linked List
 * 删除链表中的节点
 *
 * 脑筋急转弯题。。
 *
 * A->B->C->D  删除第二个节点
 *
 * 第一步: A->C->C->D  把自己变成下一个人
 * 第二步: A->C->D     把下一个人移除
 *
 * 如何让自己在世界上消失，但又不死？ —— 将自己完全变成另一个人，再杀了那个人就行了。
 *
 */
public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
