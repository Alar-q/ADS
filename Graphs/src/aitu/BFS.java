package aitu;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<T extends Comparable<T>> extends Search<T> {
    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<>(true, true);

        graph.addEdge(1, 2, 10d);
        graph.addEdge(1, 4, 10d);
        graph.addEdge(2, 1, 10d);
//        graph.addEdge(2, 3, 10d);

        System.out.println(graph);

        BFS<Integer> bfs = new BFS<>(graph, 2);
        System.out.println(bfs.pathTo(4)); // 3
    }

    public BFS(MyGraph<T> graph, T source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<T> graph, T current) {
        count = 1;
        marked.add(current);
        // Queue
        LinkedList<T> linkedList = new LinkedList<>();
        linkedList.addFirst(current);
        while (!linkedList.isEmpty()) {
            T v = linkedList.removeLast();
            for (T id : graph.getVertex(v).getAdjacentIdentifiers()) {
                if (!marked.contains(id)) {
                    count++;
                    marked.add(id);
                    edgeTo.put(id, v); // id предшествует v
                    linkedList.addFirst(id);
                }
            }
        }
    }
}
