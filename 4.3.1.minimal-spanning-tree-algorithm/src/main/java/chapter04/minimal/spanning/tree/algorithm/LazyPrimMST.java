package chapter04.minimal.spanning.tree.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小生成树的Prim算法的延时实现.
 */
public class LazyPrimMST {

    private boolean[] marked; // 最小生成树的顶点

    private Deque<Edge> mst; // 最小生成树的边

    private MinPQ<Edge> pq; // 横切边(包括失效边)

    public LazyPrimMST(EdgeWeightedGraph edgeWeightedGraph) {
        pq = new MinPQ<>();
        marked = new boolean[edgeWeightedGraph.V()];
        mst = new LinkedList<>();
        visit(edgeWeightedGraph, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.delMin(); // 从pq中得到权重最小的边
            int v = edge.eithter();
            int w = edge.other(v);
            if (marked[v] && marked[w]) { //跳过失效的边
                continue;
            }
            mst.add(edge); // 将边添加到树中
            if (!marked[v]) { // 将顶点v或w添加到树中
                visit(edgeWeightedGraph, v);
            }
            if (!marked[w]) {
                visit(edgeWeightedGraph, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph edgeWeightedGraph, int v) {
        // 标记顶点v并将所有连接v和未被标记顶点的边加入pq
        marked[v] = true;
        for (Edge edge : edgeWeightedGraph.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.insert(edge);
            }
        }
    }

    private Iterable<Edge> edges() {
        return mst;
    }
}
