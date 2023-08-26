package aitu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * MyGraph - структура данных, которая основывается на HashMap
 * и предоставляет key-vertex значения, где key - значение самой вершины.
 *
 * T - уникальный идентификатор узла и его значение сразу.
 * По умолчанию граф не направленный.
 * */
public class MyGraph<T extends Comparable<T>> {
    public static void log(String message){
        System.out.println(message);
    }

    private final boolean isDirected, isWeighted;
    private final HashMap<T, Vertex<T>> map;


    public MyGraph(boolean isDirected, boolean isWeighted){
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        map = new HashMap<T, Vertex<T>>();
    }

    public Vertex<T> getVertex(T identifier){
        return map.get(identifier);
    }

    public void addVertex(T v){
        map.put(v, new Vertex<T>(v));
    }

    public void addEdge(T src, T dst, Double weight){
        if (!hasVertex(src)) {
            addVertex(src);
        }

        if (!hasVertex(dst)) {
            addVertex(dst);
        }

        if (hasEdge(src, dst) || src.equals(dst)){
            log("Reject parallels or self-loops: " + src + " - " + dst + ".");
            return; // reject parallels & self-loops
        }

        map.get(src).addAdjacentVertex(dst, weight);

        if (!isDirected) {
            map.get(dst).addAdjacentVertex(src, weight);
        }
    }

    public void addEdge(T src, T dst) {
        if(!isWeighted){
            addEdge(src, dst, null);
        }
        else {
            log("Graph is weighted. No weight value provided.");
        }
    }


    public boolean hasVertex(T identifier){
        return map.containsKey(identifier);
    }


    public boolean hasEdge(T src, T dst){
        if (!hasVertex(src)) {
            return false;
        }
        return map.get(src).isAdjacent(dst);
    }


    public int getVerticesCount() {
        return map.size();
    }


    /**
    * Можно оптимизировать запоминанием количества ребер, а не высчитывая каждый раз.
    * */
    public int getEdgesCount() {
        int count = 0;

        for (T identifier : map.keySet()) {
            count += map.get(identifier).getAdjacentVertexCount();
        }

        if (isDirected) {
            count /= 2;
        }

        return count;
    }

    public boolean isDirected(){
        return isDirected;
    }

    public boolean isWeighted(){
        return isWeighted;
    }

    public Collection<Vertex<T>> getVertices(){
        return map.values();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Vertex<T> v: map.values()){
            sb.append(v.toString()).append('\n');
        }
        return sb.toString();
    }

}
