package com.example.algorithm.leetcode;

public class ReverseList {

    public static void main(String[] args) {
//[1,2,3,4,5]

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next=listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = new ReverseList().reverseList(listNode1);

        System.out.println(listNode);

    }

    static class ListNode {
        int val;
        ListNode next;

       public ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pNode = head.next;
        head.next = null;
        while (pNode != null) {

            ListNode tmpNode = pNode.next;
            pNode.next = head;
            head = pNode;
            pNode = tmpNode;
        }

        return head;
    }
}
