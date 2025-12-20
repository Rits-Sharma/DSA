package Leetcode;

public class Leetcode21 {
    public static void main(String[] args) {
        ListNode root1 = null;
        root1 = insertAtEnd(root1,1);
        root1 = insertAtEnd(root1,2);
        root1 = insertAtEnd(root1,4);
        ListNode root2 = null;
        root2 = insertAtEnd(root2,1);
        root2 = insertAtEnd(root2,3);
        root2 = insertAtEnd(root2,4);
        ListNode mergeList = mergeTwoLists(root1, root2);
        displayNode(mergeList);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeHead = new ListNode(0);
        ListNode head = mergeHead;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                head.next = temp1;
                temp1 = temp1.next;
            } else {
                head.next = temp2;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        if (temp1 != null) {
            head.next = temp1;
        }
        else {
            head.next = temp2;
        }
        return mergeHead.next;
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
}
