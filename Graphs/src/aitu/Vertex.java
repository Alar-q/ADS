package aitu;

import java.util.HashMap;

public class Vertex<T> {
    private final T identifier;
    // Здесь можно не только дистанцию хранить, а вообще какой-нибудь сложный класс
    private final HashMap<T, Double> adjacents;

    public Vertex(T identifier){
        this.identifier = identifier;
        this.adjacents = new HashMap<T, Double>();
    }

    public void addAdjacentVertex(T dest, Double weight){
        adjacents.put(dest, weight);
    }

    public boolean isAdjacent(T identifier){
        return adjacents.containsKey(identifier);
    }

    public int getAdjacentVertexCount(){
        return adjacents.size();
    }

    public Iterable<T> getAdjacentIdentifiers(){
        return adjacents.keySet();
    }

    public T getIdentifier() {
        return identifier;
    }

    public HashMap<T, Double> getAdjacents(){
        return adjacents;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(identifier.toString()).append(": ");
        for(T t: getAdjacentIdentifiers()){
            sb.append(t.toString()).append(", ");
        }
        return sb.toString();
    }
}
