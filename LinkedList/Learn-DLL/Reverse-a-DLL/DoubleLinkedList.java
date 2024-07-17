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

    public static Node reverseDLL(Node head) {
        Node current = head, prev = null;
        while(current!=null){
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }

        return prev.prev;

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
        System.out.println("Before Reversing : \n");
        printDLL(head);
        System.out.println();
        head = reverseDLL(head);
        System.out.println("After Reversing : \n");
        printDLL(head);

    }
}
