package Leetcode.June;

public class L2130_Maximum_Twin_Sum_of_a_Linked_List {
    public static void main(String[] args) {
        int[] heads = {5,4,2,1};

        ListNode head = new ListNode(heads[0]);
        ListNode curr = head;

        for (int i = 1; i < heads.length; i++) {
            curr.next = new ListNode(heads[i]);
            curr = curr.next;
        }

        System.out.println(pairSum(head));
    }

    private static int pairSum(ListNode head) {
        if (head == null) return 0;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverse(slow);

        int ans = 0;
        while (revHead != null) {
            ans = Math.max(ans, (head.val + revHead.val));
            head = head.next;
            revHead = revHead.next;
        }

        return ans;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


