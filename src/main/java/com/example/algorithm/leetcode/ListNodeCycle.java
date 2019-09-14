package com.example.algorithm.leetcode;

public class ListNodeCycle {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }


        ListNode pNode = head.next;
        ListNode qNode = head.next.next;

        while (qNode != null && pNode != null && qNode.next != null && pNode.next != null) {
            if (qNode.val == pNode.val) {
                return true;
            }
            pNode = pNode.next;
            qNode = qNode.next.next;
        }

        return false;

    }
}
