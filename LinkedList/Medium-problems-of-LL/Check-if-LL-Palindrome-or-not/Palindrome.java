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

    public static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }

    public static Node middleLL(Node head) {

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean isPalindrome(Node head) {
        Node middlNode = middleLL(head);
        Node newHead = reverseLL(middlNode);
        Node firstP = head, secondP = newHead;
        while (secondP != null) {
            if (firstP.data != secondP.data) {
                reverseLL(newHead);
                return false;
            }
            firstP = firstP.next;
            secondP = secondP.next;
        }
        reverseLL(newHead);
        return true;
    }

    public static void displayLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

}

public class Palindrome {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 1 };
        Node head = LinkedList.createLL(arr);
        boolean isPalindromeExist = LinkedList.isPalindrome(head);
        System.out.println(isPalindromeExist);

    }
}
