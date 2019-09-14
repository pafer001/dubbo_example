package com.example.algorithm.leetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int tmpValue = 0;

        ListNode headNode = null;
        ListNode tailNode = null;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + tmpValue;

            ListNode listNode = new ListNode(val % 10);

            if (headNode == null) {
                headNode = listNode;
                tailNode = headNode;
            } else {
                tailNode.next = listNode;
                tailNode = listNode;
            }
            tmpValue = val / 10;
            l1 = l1.next;
            l2= l2.next;

        }

        while (l1 != null) {
            int val = l1.val + tmpValue;

            ListNode listNode = new ListNode(val % 10);

            if (headNode == null) {
                headNode = listNode;
                tailNode = headNode;
            } else {
                tailNode.next = listNode;
                tailNode = listNode;
            }
            tmpValue = val / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + tmpValue;

            ListNode listNode = new ListNode(val % 10);

            if (headNode == null) {
                headNode = listNode;
                tailNode = headNode;
            } else {
                tailNode.next = listNode;
                tailNode = listNode;
            }
            tmpValue = val / 10;
            l2 = l2.next;
        }

        if (tmpValue != 0) {
            ListNode listNode = new ListNode(tmpValue);
            tailNode.next =listNode;
        }
        return headNode;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
