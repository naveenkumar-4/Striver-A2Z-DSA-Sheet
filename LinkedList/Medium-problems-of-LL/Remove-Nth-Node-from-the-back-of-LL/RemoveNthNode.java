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

    public static Node removeNthNode(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node deleteNode = slow.next;
        slow.next = slow.next.next;
        deleteNode.next = null;

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

public class RemoveNthNode {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        Node head = LinkedList.createLL(arr);
        head = LinkedList.removeNthNode(head, k);
        LinkedList.displayLL(head);
    }
}