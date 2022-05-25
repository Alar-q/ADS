package Assignment4;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedList;


public class Vertex<T> {
    private T data;
    private final HashMap<T, Double> adjacents;

    public Vertex(T data){
        setData(data);
        this.adjacents = new HashMap<>();
    }

    public void addAdjacentVertex(T dest, double weight){
        adjacents.put(dest, weight);
    }

    @Nullable
    public Double getWeight(T v){
        return adjacents.get(v);
    }

    public boolean isAdjacent(T v){
        return adjacents.containsKey(v);
    }

    public int getAdjacentVertexCount(){
        return adjacents.size();
    }

    public Iterable<T> getAdjacentVertices(){
        LinkedList<T> arr = new LinkedList<>();
        for(T v: adjacents.keySet()){
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
