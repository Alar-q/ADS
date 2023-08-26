package aitu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS<T extends Comparable<T>> extends Search<T> {

    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<>(true, true);

        graph.addEdge(1, 2, 10d);
        graph.addEdge(1, 4, 10d);
        graph.addEdge(2, 1, 10d);
        // graph.addEdge(2, 3, 10d);

        System.out.println(graph);

        DFS<Integer> dfs = new DFS<>(graph, 2);
        System.out.println(dfs.pathTo(4)); // 3
    }

    public DFS(MyGraph<T> graph, T source) {
        super(source);
        dfs(graph, source);
    }

    /*
    // Всё равно работает как bfs немного, типа чекает всех соседей, потом идет в глубь
    private void dfs(MyGraph<T> graph, T current) {
        count = 1;
        marked.add(current);
        // Stack
        LinkedList<T> linkedList = new LinkedList<>();
        linkedList.addLast(current);
        while (!linkedList.isEmpty()) {
            T v = linkedList.removeLast();
            for (T id : graph.getVertex(v).getAdjacentIdentifiers()) {
                if (!marked.contains(id)) {
                    count++;
                    marked.add(id);
                    edgeTo.put(id, v); // id предшествует v
                    linkedList.addLast(id);
                }
            }
        }
    }*/

    private void dfs(MyGraph<T> graph, T current) {
        marked.add(current);
        count++;
        for (T v : graph.getVertex(current).getAdjacentIdentifiers()) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}
