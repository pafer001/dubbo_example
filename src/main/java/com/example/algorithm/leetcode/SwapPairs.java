package com.example.algorithm.leetcode;

public class SwapPairs {

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

        ListNode listNode = new SwapPairs().swapPairs(listNode1);

        System.out.println(listNode);

    }
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode emptyNode = new ListNode(-1);
        emptyNode.next = head;
        head =  emptyNode;

        ListNode pNode =  head;
        while (pNode.next != null && pNode.next.next != null) {

            ListNode nextNode =  pNode.next;
            pNode.next = pNode.next.next;
            nextNode.next = pNode.next.next;

            pNode.next.next = nextNode;

            pNode = pNode.next.next;
        }

        return head.next;
    }
}
