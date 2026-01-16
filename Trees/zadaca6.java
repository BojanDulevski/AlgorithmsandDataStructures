Во следната задача треба да изградите бинарно дрво со N јазли, за кое ќе треба да одговорите на Q прашања од видот „колку јазли со точно две деца има во поддрвото на избран јазол“.

Секој јазол ќе има уникатно име. Името на коренот на дрвото секогаш ќе ви биде дадено прво.

Влезот ќе содржи N+Q редови од видот

root ime - Треба да го поставите коренот на дрвото да биде јазелот со име ime

add parent_name child_name - Треба да додадете дете јазел со име child_name на јазелот со име parent_name

ask node_name - Треба да го одговориме прашањето за поддрвото на јазелот со име node_name


import java.util.*;

class Node {
    String name;
    Node left, right;
    Node(String name) {
        this.name = name;
    }
}

public class Main {
    static Map<String, Node> nodes = new HashMap<>();

    static int countTwoChildren(Node node) {
        if (node == null) return 0;
        int count = 0;
        if (node.left != null && node.right != null) count = 1;
        return count + countTwoChildren(node.left) + countTwoChildren(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        sc.nextLine();
        Node root = null;
        for (int i = 0; i < N + Q; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            if (parts[0].equals("root")) {
                root = new Node(parts[1]);
                nodes.put(parts[1], root);
            } else if (parts[0].equals("add")) {
                Node parent = nodes.get(parts[1]);
                Node child = new Node(parts[2]);
                if (parts[3].equals("LEFT")) parent.left = child;
                else parent.right = child;
                nodes.put(parts[2], child);
            } else if (parts[0].equals("ask")) {
                Node node = nodes.get(parts[1]);
                System.out.println(countTwoChildren(node));
            }
        }
    }
}
