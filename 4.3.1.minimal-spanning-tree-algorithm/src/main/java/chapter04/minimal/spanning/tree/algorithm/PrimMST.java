package chapter04.minimal.spanning.tree.algorithm;

/**
 * 最小生成树的Prim算法(即时版本).
 */
public class PrimMST {

    private Edge[] edgeTo; // 距离树最近的边

    private Double[] distTo; // distTo[w]=edgeTo[w].weight()

    private boolean[] marked; // 如果v在树中则为true

    private IndexMinPQ<Double> pq; // 有效的横切边

    public PrimMST(EdgeWeightedGraph edgeWeightedGraph) {
        edgeTo = new Edge[edgeWeightedGraph.V()];
        distTo = new Double[edgeWeightedGraph.V()];
        marked = new boolean[edgeWeightedGraph.V()];
        for (int v = 0; v < edgeWeightedGraph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(edgeWeightedGraph.V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(edgeWeightedGraph, pq.delMin()); // 将最近的顶点添加到树中
        }
    }

    private void visit(EdgeWeightedGraph edgeWeightedGraph, int v) {
        //将顶点添加到v中，更新数据
        marked[v] = true;
        for (Edge edge : edgeWeightedGraph.adj(v)) {
            int w = edge.other(v);
            if (marked[w]) { // v-w失效
                continue;
            }
            if (edge.weight() < distTo[w]) {
                // 连接w和树的最佳边Edge变为edge
                edgeTo[w] = edge;
                distTo[w] = edgeTo[w].weight();
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
}
