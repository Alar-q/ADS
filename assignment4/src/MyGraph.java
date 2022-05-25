package Assignment4;

import java.util.HashMap;

public class MyGraph<T> {

    private final boolean undirected;
    private final HashMap<T, Vertex<T>> vertices;


    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        vertices = new HashMap<>();
    }

    public MyGraph(){
        this(true);
    }


    // Item + Edges
    public void addVertex(T v){
        vertices.put(v, new Vertex<T>(v));
    }

    public void addEdge(T src, T dst, Double weight){
        if(!hasVertex(src))
            addVertex(src);

        if(!hasVertex(dst))
            addVertex(dst);

        if (hasEdge(src, dst) || src.equals(dst))
            return; // reject parallels & self-loops

        Vertex<T> s = vertices.get(src);
        Vertex<T> d = vertices.get(dst);
        // add
        s.addAdjacentVertex(dst, weight);
        if(undirected)
            d.addAdjacentVertex(src, weight);
    }


    public int getVerticesCount(){
        return vertices.size();
    }

    public int getEdgesCount(){
        int n = 0;
        for(int i=0; i<vertices.size(); i++){
            n += vertices.get(i).getAdjacentVertexCount();
        }
        return n;
    }


    public boolean hasVertex(T v){
        return vertices.containsKey(v);
    }

    public boolean hasEdge(T source, T dest){
        Vertex<T> src = vertices.get(source);
//        Vertex<T> dst = vertices.get(dest);
        return src.isAdjacent(dest);
    }

    public Iterable<T> adjacencyList(T v){
        Vertex<T> vertex = vertices.get(v);
        return vertex.getAdjacentVertices();
    }

    public Vertex<T> getVertex(T data){
        return vertices.get(data);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Vertex<T> v: vertices.values()){
            sb.append(v.toString()).append('\n');
        }
        return sb.toString();
    }
}
