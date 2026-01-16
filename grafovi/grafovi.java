You're given objects connected by streets and grouped into cities. A group of objects is considered to belong to the same city if each object is connected to at least one other object in that city and is not connected to any object from another city. Determine how many cities the given objects are grouped into.



Input: The first line contains the number of objects N. The next N lines contain the names of the objects. The next line contains the number of streets M, followed by M lines that specify the objects connected by each street.

Output: The number of cities the given objects are grouped into.

Example:

Input:

        5
School1
        ApartmentBuilding1
Park1
        Supermarket1
Hospital1
2
School1 ApartmentBuilding1
Park1 Supermarket1

Output: 3 (Explanation: School1 and ApartmentBuilding1 are in one city, Park1 and Supermarket1 in another, and Hospital1 in a third.)


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Читање на број на објекти
        int N = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> graph = new HashMap<>();

        // Читање на имиња на објекти и креирање празна листа на соседи
        List<String> objects = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String obj = sc.nextLine().trim();
            objects.add(obj);
            graph.put(obj, new ArrayList<>());
        }

        // Читање на улици (edges)
        int M = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < M; i++) {
            String[] street = sc.nextLine().trim().split(" ");
            String a = street[0];
            String b = street[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // Set за посетени јазли
        Set<String> visited = new HashSet<>();
        int cityCount = 0;

        // DFS за пребројување на поврзани компоненти
        for (String obj : objects) {
            if (!visited.contains(obj)) {
                dfs(obj, graph, visited);
                cityCount++;
            }
        }

        System.out.println(cityCount);
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
