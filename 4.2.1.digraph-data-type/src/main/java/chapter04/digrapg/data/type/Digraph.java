package chapter04.digrapg.data.type;

/**
 * 有向图数据类型.
 */
public class Digraph {

    private final Integer V;

    private Integer E;

    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Integer V() {
        return V;
    }

    public Integer E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph reverseDigraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                reverseDigraph.addEdge(w, v);
            }
        }
        return reverseDigraph;
    }
}
