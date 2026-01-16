Given routers labeled from 0 to N−1 that are connected in a network, the failure of a specific router R may split the network into groups of routers that are no longer connected. Each router in a group is connected to at least one other router from that group, and isn't connected to any routers outside of that group. Determine the number of such groups that will form if router R fails.



Input: The first line contains the number of routers N. The next line contains the number of connections between the routers M, followed by M lines that specify which routers are connected with each connection. The last line contains the router R that failed.

        Output: The number of groups of routers.

Example:

Input:

        5
        4
        0 1
        1 2
        2 3
        2 4
        1



Output: 2 (Explanation: If router 1 fails, the network will split into two groups: 0 and 2,3,4.)


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] edge = sc.nextLine().trim().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int R = Integer.parseInt(sc.nextLine());
        Set<Integer> visited = new HashSet<>();
        visited.add(R);
        int groups = 0;
        for (int i = 0; i < N; i++) {
            if (!visited.contains(i)) {
                dfs(i, graph, visited, R);
                groups++;
            }
        }
        System.out.println(groups);
    }

    static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, int R) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor) && neighbor != R) {
                dfs(neighbor, graph, visited, R);
            }
        }
    }
}
