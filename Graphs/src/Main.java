import aitu.BFS;
import aitu.DFS;
import aitu.MyGraph;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<>(true, true);

        graph.addEdge(1, 2, 10d);
        graph.addEdge(1, 4, 10d);
        graph.addEdge(2, 1, 10d);
//        graph.addEdge(2, 3, 10d);

        System.out.println(graph);

        DFS<Integer> dfs = new DFS<>(graph, 2);
        System.out.println(dfs.pathTo(3));

        BFS<Integer> bfs = new BFS<>(graph, 2);
        System.out.println(bfs.pathTo(4));
    }
}