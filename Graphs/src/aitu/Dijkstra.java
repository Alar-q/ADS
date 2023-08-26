package aitu;

import java.util.*;

public class Dijkstra<T extends Comparable<T>> extends Search<T> {

    public static void main(String[] args) {
        MyGraph<String> graph = new MyGraph<>(false, true);

        graph.addEdge("A", "B", 0.5);
        graph.addEdge("A", "C", 1d);

        graph.addEdge("C", "D", 1d);
        graph.addEdge("C", "E", 4d);

        graph.addEdge("B", "E", 4d);
//        graph.addEdge("B", "A", 0.5);

//        graph.addEdge("E", "C", 4d);
        graph.addEdge("E", "F", 1d);

//        graph.addEdge("D", "C", 1d);
        graph.addEdge("D", "F", 1d);

        Dijkstra<String> dijkstra = new Dijkstra<>(graph, "A");
        System.out.println(dijkstra.pathTo("E"));

        System.out.println(dijkstra);
    }

    public static void log(Object message){
//        System.out.println(message.toString());
    }

    private LinkedList<T> unsettledNodes;
    private Map<T, Double> distances;
    private MyGraph<T> graph;

    public Dijkstra(MyGraph<T> graph, T source) {
        super(source);
        unsettledNodes = new LinkedList<>();
        distances = new HashMap<>();
        this.graph = graph;
        if (graph.isWeighted()) {
            dijkstra();
        }
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.addLast(source);

        while (!unsettledNodes.isEmpty()) {
            T currentNodeId = unsettledNodes.removeFirst(); // like a queue

            if(marked.contains(currentNodeId)){
                continue;
            }
            marked.add(currentNodeId);

            Vertex<T> currentVertex = graph.getVertex(currentNodeId);
            HashMap<T, Double> adjacents = currentVertex.getAdjacents();

            log(currentNodeId + ": " + adjacents);

            T prev = edgeTo.get(currentNodeId);

            for (T adjacentId : adjacents.keySet()) {
                count++;

                log(adjacentId);

                if(prev != null && prev.equals(adjacentId)){
                    continue;
                }

                Double currentDistance = distances.get(currentNodeId);
                Double edgeWeight = adjacents.get(adjacentId);
                Double newDistance = currentDistance + edgeWeight;

                log("newDistance " + newDistance + ", was " + distances.get(adjacentId));

                if (!distances.containsKey(adjacentId) || newDistance < distances.get(adjacentId)) {
                    log("True");
                    distances.put(adjacentId, newDistance);
                    edgeTo.put(adjacentId, currentNodeId);
                    unsettledNodes.addLast(adjacentId);
                }
            }
        }
    }

    public Map<T, Double> getDistances(){
        return distances;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Node (Distance, Previous)\n");

        for(Vertex<T> v: graph.getVertices()){
            T id = v.getIdentifier();
            sb
                    .append(id)
                    .append(" (")
                    .append(distances.get(id))
                    .append(", ")
                    .append(edgeTo.get(id))
                    .append(")\n");
        }
        sb.append("Vertices: ").append(graph.getVerticesCount()).append("\n");
        sb.append("Edges: ").append(graph.getEdgesCount()).append("\n");
        sb.append("Node traversals: ").append(count);

        return sb.toString();
    }
}