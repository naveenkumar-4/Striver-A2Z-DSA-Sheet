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

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head, fast = head;
        fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node middleNode = slow.next;
        slow.next = slow.next.next;
        middleNode.next = null;


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

public class DeleteMiddle {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = LinkedList.createLL(arr);
        System.out.println("Before Deletion");
        LinkedList.displayLL(head);
        System.out.println("After Deletion");
        head = LinkedList.deleteMiddle(head);
        LinkedList.displayLL(head);
    }
}