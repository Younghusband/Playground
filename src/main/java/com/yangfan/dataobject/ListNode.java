package com.yangfan.dataobject;


public class ListNode {
    public int val;

    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode add(int val) {
        this.next = new ListNode(val);
        return this;
    }
}
