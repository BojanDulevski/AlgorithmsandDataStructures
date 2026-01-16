Дадени се градови и патишта кои постојат помеѓу нив. Дел од патиштата се поплавени и не може да се користат, што може да доведе до тоа градовите да се поделат на групи што не се меѓусебно поврзани. Секој град од една група е поврзан со барем еден друг град од групата преку достапни (непоплавени) патишта, а не е поврзан со градови надвор од групата. Да се одреди колку вакви групи ќе има во случај на поплава.



Влез: Во првиот ред е даден бројот на патишта M. Во следните M редови се дадени градовите кои ги поврзува секој пат. Потоа е даден бројот k на поплавени патишта, а во следните k редови се дадени поплавените патишта.

Излез:  Бројот на групи на градови кои ќе останат меѓусебно поврзани.

Пример:

Влез:

        6
London Paris
Paris Brussels
Brussels Amsterdam
London Brussels
Paris Berlin
Berlin Warsaw
2
Paris Berlin
London Brussels

Излез: 2 (Објаснување: Ако не може да се користат патиштата Paris-Berlin и London-Brussels, градовите ќе се поделат во две групи: {London, Paris, Brussels, Amsterdam} и {Berlin, Warsaw})



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> cities = new HashSet<>();
        List<String[]> roads = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] road = sc.nextLine().trim().split(" ");
            roads.add(road);
            cities.add(road[0]);
            cities.add(road[1]);
        }
        int k = Integer.parseInt(sc.nextLine());
        Set<String> flooded = new HashSet<>();
        for (int i = 0; i < k; i++) {
            String[] road = sc.nextLine().trim().split(" ");
            flooded.add(road[0] + "-" + road[1]);
            flooded.add(road[1] + "-" + road[0]);
        }
        for (String city : cities) {
            graph.put(city, new ArrayList<>());
        }
        for (String[] road : roads) {
            String a = road[0];
            String b = road[1];
            if (!flooded.contains(a + "-" + b)) {
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
        }
        Set<String> visited = new HashSet<>();
        int groups = 0;
        for (String city : cities) {
            if (!visited.contains(city)) {
                dfs(city, graph, visited);
                groups++;
            }
        }
        System.out.println(groups);
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
