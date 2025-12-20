package Leetcode;

class ListNode {
    int val;
    ListNode next;
//    ListNode() {}
    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leetcode2487 {
    public static void main(String[] args) {
        ListNode root = null;
        root = insertAtEnd(root, 5);
        root = insertAtEnd(root, 2);
        root = insertAtEnd(root, 13);
        root = insertAtEnd(root, 3);
        root = insertAtEnd(root, 8);
        root = removeNodes(root);
//        root = reverseNode(root);
        displayNode(root);
    }

    public static ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return null;
        head = reverseNode(head);
        ListNode curr = head;
        ListNode temp = head.next;
        while(temp != null) {
            if(temp.val < curr.val) {
                curr.next = temp.next;
            }
            else curr = temp;
            temp = temp.next;
        }
        head = reverseNode(head);
        return head;
    }

    public static ListNode insertAtEnd(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        if(head == null) return newNode;
        ListNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    public static void displayNode(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    public static ListNode reverseNode(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;  // store next
            curr.next = prev;  // reverse link
            prev = curr;       // move prev
            curr = temp;       // move curr
        }
        return prev; // new head
    }

}
