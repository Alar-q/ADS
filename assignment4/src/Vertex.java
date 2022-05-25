package Assignment4;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedList;


public class Vertex<T> {
    private T data;
    private final HashMap<T, Double> edges;

    public Vertex(T data){
        setData(data);
        this.edges = new HashMap<>();
    }

    public void addAdjacentVertex(T dest, double weight){
        edges.put(dest, weight);
    }

    @Nullable
    public Double getWeight(T v){
        return edges.get(v);
    }

    public boolean isAdjacent(T v){
        return edges.containsKey(v);
    }

    public int getAdjacentVertexCount(){
        return edges.size();
    }

    public Iterable<T> getAdjacentVertices(){
        LinkedList<T> arr = new LinkedList<>();
        for(T v: edges.keySet()){
            arr.addFirst(v);
        }
        return arr;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(data.toString()).append(": ");
        for(T t: getAdjacentVertices()){
            sb.append(t.toString()).append(", ");
        }
        return sb.toString();
    }
}
