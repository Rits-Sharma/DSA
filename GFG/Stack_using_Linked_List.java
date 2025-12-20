package GFG;

// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Stack class
class myStack {
    Node top;
    int size;

    public myStack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top==null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void pop() {
        if(isEmpty()) return;
        top = top.next;
        size--;
    }

    public int peek() {
        if(isEmpty()) return -1;
        return top.data;
    }

    public int size() {
        return size;
    }
}


public class Stack_using_Linked_List {
    public static void main(String[] args) {
        myStack stack = new myStack();
        System.out.println(stack.isEmpty());
        stack.push(15);
        stack.push(14);
        stack.push(13);
        stack.push(12);
        System.out.println(stack.size);
        System.out.println(stack.peek());
    }
}
