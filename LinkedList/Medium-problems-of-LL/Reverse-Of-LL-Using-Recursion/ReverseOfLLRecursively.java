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

    public static Node reverseLL(Node head){
        if(head == null || head.next == null) return head;

        Node newHead = reverseLL(head.next);
        Node nextNode = head.next;
        nextNode.next = head;
        head.next=null;
        return newHead;
    }

    public static void displayLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

}

public class ReverseOfLLRecursively {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = LinkedList.createLL(arr);
        System.out.println("Linked List: ");
        LinkedList.displayLL(head);
        System.out.println();
        head = LinkedList.reverseLL(head);
        System.out.println("Middle of LL: ");
        LinkedList.displayLL(head);

    }
}
