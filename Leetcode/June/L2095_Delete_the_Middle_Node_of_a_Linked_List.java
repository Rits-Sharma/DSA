package Leetcode.June;

public class L2095_Delete_the_Middle_Node_of_a_Linked_List {
    public static void main(String[] args) {
        int[] heads = {1, 3, 4, 7, 1, 2, 6};

        ListNode head = new ListNode(heads[0]);
        ListNode curr = head;

        for (int i = 1; i < heads.length; i++) {
            curr.next = new ListNode(heads[i]);
            curr = curr.next;
        }

        ListNode temp = deleteMiddle(head);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (prev.next != slow) {
            prev = prev.next;
        }
        prev.next = prev.next.next;

        return head;
    }
}
