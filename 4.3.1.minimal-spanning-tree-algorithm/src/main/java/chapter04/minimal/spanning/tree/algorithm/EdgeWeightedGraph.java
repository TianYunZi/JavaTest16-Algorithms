package chapter04.minimal.spanning.tree.algorithm;

/**
 * 加权无向图的数据类型.
 */
public class EdgeWeightedGraph {

    private final Integer V; // 顶点的总数

    private Integer E; // 边的总数

    private Bag<Edge>[] adj; // 邻接表

    public EdgeWeightedGraph(Integer v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Integer V() {
        return V;
    }

    public Integer E() {
        return E;
    }

    public void addEdge(Edge edge) {
        int v = edge.eithter();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // only add one copy of each self loop
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }
}
