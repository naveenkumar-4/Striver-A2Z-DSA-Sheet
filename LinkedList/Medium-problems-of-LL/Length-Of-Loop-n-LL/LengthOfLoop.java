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

    public static int lengthOfLoop(Node slow, Node fast) {
        int count = 1;
        fast = fast.next;
        while (fast != slow) {
            count++;
            fast = fast.next;
        }
        return count;
    }

    public static int loopOfLL(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return lengthOfLoop(slow, fast);
            }
        }
        return 0;
    }

    public static void displayLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

}

public class LengthOfLoop {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = LinkedList.createLL(arr);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        int lengthOfLoop = LinkedList.loopOfLL(head);
        System.out.println("Length of Loop in Linked List is: ");
        System.out.println(lengthOfLoop);

    }
}
