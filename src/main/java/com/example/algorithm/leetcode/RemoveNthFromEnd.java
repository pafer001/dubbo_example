package com.example.algorithm.leetcode;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);

        new RemoveNthFromEnd().removeNthFromEnd(listNode, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;
        for (int i =0 ; i <= n && p1 != null; i++) {
            p1 = p1.next;
        }


        while ( p1!= null) {
            p1 = p1.next;
            p2 = p2.next;
        }


         p2.next = p2.next.next;

        return dummy.next;
    }

    static public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
