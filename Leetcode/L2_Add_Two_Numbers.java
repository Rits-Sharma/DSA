package Leetcode;

public class L2_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        a.next = new ListNode(9);
        a.next.next = new ListNode(9);
        a.next.next.next = new ListNode(9);

        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
        b.next.next = new ListNode(9);
        b.next.next.next = new ListNode(9);
        b.next.next.next.next = new ListNode(9);
        b.next.next.next.next.next = new ListNode(9);
        b.next.next.next.next.next.next = new ListNode(9);

        ListNode ans = addTwoNumbers(a, b);
        while (ans != null) {
            if(ans.next == null) System.out.print(ans.val);
            else System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = new ListNode();
        ListNode result = temp;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l1 = l1.next;   l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry > 0) temp.next = new ListNode(carry);
        return result.next;
    }
}
