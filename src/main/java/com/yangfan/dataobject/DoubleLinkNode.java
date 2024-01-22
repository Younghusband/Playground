package com.yangfan.dataobject;

/**
 * 双向链表节点
 */
public class DoubleLinkNode {
    public int val;
    public DoubleLinkNode prev;
    public DoubleLinkNode next;
    public DoubleLinkNode(int val){
        this.val = val;
    }
    public void setNext(DoubleLinkNode next) {
        this.next = next;
    }
    public void setPrev(DoubleLinkNode prev) {
        this.prev = prev;
    }

}
