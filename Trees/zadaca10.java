Дадено ви е бинарно пребарувачко дрво со N цели броеви.

Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:

ќе најдете колку елементи во дрвото се помали од T
Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.

Влезот ќе содржи N+Q редови од видот

insert value - Треба да ја вметнете вредноста value во дрвото.

ask value - Треба да одговорите колку елементи во дрвото имаат вредност помала од value

Пример и структура на влезот:

Влез

        Објаснување

Излез


10 7
insert 6
insert 3
insert 7
ask 3
ask 6
insert 4
insert 1
insert 2
insert 5
insert 9
ask 3
ask 9
insert 8
insert 10
ask 8
ask 4
ask 5
Прикажано е изгледот на дрвото при секое од 7те прашања во влезот






0
        1
        2
        7
        7
        3
        4
import java.util.*;

class Node {
    int val;
    Node left, right;
    int leftCount; // број на јазли во левото поддрво
    Node(int val) {
        this.val = val;
        this.leftCount = 0;
    }
}

public class Main {

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
            root.leftCount++; // зголеми број на јазли во левото поддрво
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    static int countSmaller(Node root, int val) {
        int count = 0;
        Node cur = root;
        while (cur != null) {
            if (val <= cur.val) {
                cur = cur.left;
            } else {
                count += 1 + cur.leftCount; // сите леви + самиот јазел
                cur = cur.right;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        sc.nextLine();

        Node root = null;

        for (int i = 0; i < N + Q; i++) {
            String[] parts = sc.nextLine().split(" ");
            if (parts[0].equals("insert")) {
                int val = Integer.parseInt(parts[1]);
                root = insert(root, val);
            } else if (parts[0].equals("ask")) {
                int val = Integer.parseInt(parts[1]);
                System.out.println(countSmaller(root, val));
            }
        }
    }
}
