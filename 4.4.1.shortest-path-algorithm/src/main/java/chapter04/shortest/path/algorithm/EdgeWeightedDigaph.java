package chapter04.shortest.path.algorithm;

/**
 * 加权有向图的数据类型.
 */
public class EdgeWeightedDigaph {

    private final Integer V; // 顶点总数

    private Integer E; // 边的总数

    private Bag<DirectedEdge>[] adj; //邻接表

    public EdgeWeightedDigaph(Integer V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
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

    public void addEdge(DirectedEdge directedEdge) {
        adj[directedEdge.from()].add(directedEdge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge directedEdge : adj[v]) {
                bag.add(directedEdge);
            }
        }
        return bag;
    }
}
