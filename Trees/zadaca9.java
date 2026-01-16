Дадено ви е бинарно пребарувачко дрво со N цели броеви.

Напишете функција со која за бинарно пребарувачко дрво и избран елемент Т од дрвото:

ќе најдете на која длабочина се наоѓа елементот T во дрвото
Ќе треба да ја искористите таа функција Q пати при градењето на дрвото.

Влезот ќе содржи N+Q редови од видот

insert value - Треба да ја вметнете вредноста value во дрвото.

ask value - Треба да одговорите на која длабочина во дрвото се наоѓа јазелот со вредност value

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






2
        1
        2
        3
        4
        3
        4


import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
    }
}

public class Main {

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    static int depth(Node root, int val) {
        int d = 1;
        Node cur = root;
        while (cur != null) {
            if (val == cur.val) return d;
            else if (val < cur.val) cur = cur.left;
            else cur = cur.right;
            d++;
        }
        return -1; // ако вредноста не постои
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
                System.out.println(depth(root, val));
            }
        }
    }
}
