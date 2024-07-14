class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
    }
}

class LinkedList {
    public static Node createLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static Node insertAtEnd(Node head, int ele) {
        if (head == null) {
            return new Node(ele);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(ele);
        temp.next = newNode;
        return head;
    }

    public static void displayLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

}

public class InsertionAtEnd {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int ele = 6;
        Node head = LinkedList.createLL(arr);
        System.out.println("Before Updation : ");
        LinkedList.displayLL(head);
        System.out.println();
        head = LinkedList.insertAtEnd(head, ele);
        System.out.println("After Updation : ");
        LinkedList.displayLL(head);

    }
}
