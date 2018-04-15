package chapter04.graph.data.type;

/**
 * Graph数据类型
 */
public class GraphDataType {

    private Integer V; // 顶点的数目

    private Integer E; // 边的数目

    private Bag<Integer>[] adj; // 邻接表

    public GraphDataType(int v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; // 创建邻接表
        for (int i = 0; i < V; i++) { // 将所有邻接表初始化为空
            adj[i] = new Bag<>();
        }
    }

    public Integer V() {
        return V;
    }

    public Integer E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); // 将w添加到v的链接表
        adj[w].add(v); // 将v添加到w的链接表
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
