package GFG;

class ListNOde {
    int data;
    ListNOde next;

    ListNOde(int x){
        data = x;
        next = null;
    }
}

public class test {
    public static void main(String[] args) {
        ListNOde root = null;
        root = insertAtEnd(root, 12);
    }
    public static ListNOde insertAtEnd(ListNOde head, int x) {
        ListNOde newNode = new ListNOde(x);
        if(head == null) return newNode;
        ListNOde temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }
}
