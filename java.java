
import java.util.Scanner;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

public class java {

    static Node intsetAttheBeginning(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        if (n == 0) return;

        Node head = new Node(input.nextInt());
        Node tail = head;

        for (int i = 1; i < n; i++) {
            tail.next = new Node(input.nextInt());
            tail = tail.next;
        }

        int target = input.nextInt();

        int count = 0;
        Node temp = head;


        while (temp != null) {
            if (temp.value == target) {
                count++;
            }
            temp = temp.next;
        }


        if (count % 2 == 1) {
            if (head.value == target) {
                head = intsetAttheBeginning(head, target);
            } else {
                Node prev = head;
                Node curr = head.next;

                while (curr != null && curr.value != target) {
                    prev = curr;
                    curr = curr.next;
                }

                Node newNode = new Node(target);
                prev.next = newNode;
                newNode.next = curr;
            }
        }


        Node p = head;
        while (p != null) {
            System.out.print(p.value);
            if (p.next != null) System.out.print("->");
            p = p.next;
        }
    }
}
