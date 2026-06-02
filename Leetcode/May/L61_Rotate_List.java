package Leetcode.May;


import Leetcode.ListNode;

public class L61_Rotate_List {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode head = list;
        list.val = head.val;
        list.next = head;
        list = rotateRight(head, 2);
        System.out.println(list.val);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(count);
        return head;
    }
}
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }