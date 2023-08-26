package aitu;

import java.util.*;

public class Search<T extends Comparable<T>> {
    protected int count;
    protected Set<T> marked;
    protected Map<T, T> edgeTo; // predecessors
    protected final T source;

    public Search(T source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(T identifier) {
        return marked.contains(identifier);
    }

    public Iterable<T> pathTo(T identifier) {
        if (!hasPathTo(identifier)) {
            return null;
        }
        LinkedList<T> ls = new LinkedList<>();
        for (T i = identifier; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }
        ls.push(source);

        return ls;
    }

    public int getCount() {
        return count;
    }

    public Map<T, T> getEdgeTo(){
        return edgeTo;
    }
}
