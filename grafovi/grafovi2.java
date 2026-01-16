You're given a group of people, some of whom know each other. The task is to organize New Year's Eve gatherings such that every person in a group celebrating together knows at least one other person in that group, and no one in the group knows anyone outside of it. Determine how many New Year's Eve gatherings will be organized by the given people.



        Input: The first line contains the number of people N. The next N lines contain the names of the people. The next line contains the number of connections M, followed by M lines that specify the pairs of people who know each other.

        Output: The number of cities the given objects are grouped into.

        Example:

        Input:

        6
        Alice
        Bob
        Charlie
        Diana
        Eve
        Frank
        3
        Alice Bob
        Charlie Diana
        Eve Frank

        Output: 3 (Explanation: Alice and Bob are one group, Charlie and Diana a second group, and Eve and Frank a third group)






import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> graph = new HashMap<>();
        List<String> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = sc.nextLine().trim();
            people.add(name);
            graph.put(name, new ArrayList<>());
        }
        int M = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < M; i++) {
            String[] pair = sc.nextLine().trim().split(" ");
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
        Set<String> visited = new HashSet<>();
        int parties = 0;
        for (String person : people) {
            if (!visited.contains(person)) {
                dfs(person, graph, visited);
                parties++;
            }
        }
        System.out.println(parties);
    }

    static void dfs(String node, Map<String, List<String>> graph, Set<String> visited) {
        visited.add(node);
        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
