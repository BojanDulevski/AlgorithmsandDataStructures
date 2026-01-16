import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> tree;

    // брои колку листови има под даден јазол
    static int countLeaves(int node) {
        // ако нема деца -> лист
        if (tree.get(node).isEmpty()) {
            return 1;
        }

        int sum = 0;
        for (int child : tree.get(node)) {
            sum += countLeaves(child);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        sc.nextLine(); // чистење на редот

        for (int i = 0; i < N + Q; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("root")) {
                // root 1 -> ништо не треба да се прави
            }
            else if (parts[0].equals("add")) {
                int parent = Integer.parseInt(parts[1]);
                int child = Integer.parseInt(parts[2]);
                tree.get(parent).add(child);
            }
            else if (parts[0].equals("ask")) {
                int node = Integer.parseInt(parts[1]);
                System.out.println(countLeaves(node));
            }
        }
    }
}
