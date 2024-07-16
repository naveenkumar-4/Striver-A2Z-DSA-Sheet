class Node {
    int data;
    Node next;
    Node prev;

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    Node(int data) {
        this.data = data;
    }
}

public class DoubleLinkedList {
    public static Node converArrToDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prevNode = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, prevNode);
            prevNode.next = newNode;
            prevNode = newNode;
        }

        return head;
    }

    public static Node deleteNode(Node head, int k) {
        if (head == null) {
            return head;
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;
        if (prevNode == null && nextNode == null) {
            return null;
        } else if (prevNode == null) {
            head = head.next;
            head.prev = null;
            return head;
        } else if (nextNode == null) {
            prevNode.next = null;
            temp.prev = null;
            return head;
        }
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        temp.next = null;
        temp.prev = null;
        return head;

    }

    public static void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = converArrToDLL(arr);
        printDLL(head);
        System.out.println();
        head = deleteNode(head, 3);
        printDLL(head);

    }
}
