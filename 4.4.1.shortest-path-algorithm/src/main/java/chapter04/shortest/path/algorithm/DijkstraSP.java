package chapter04.shortest.path.algorithm;

/**
 * 最短路径的Dijkstra算法.
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;

    private Double[] distTo;

    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigaph edgeWeightedDigaph, int s) {
        edgeTo = new DirectedEdge[edgeWeightedDigaph.V()];
        distTo = new Double[edgeWeightedDigaph.V()];
        pq = new IndexMinPQ<>(edgeWeightedDigaph.V());
        for (int v = 0; v < edgeWeightedDigaph.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(edgeWeightedDigaph, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigaph edgeWeightedDigaph, int v) {
        for (DirectedEdge directedEdge : edgeWeightedDigaph.adj(v)) {
            int w = directedEdge.to();
            if (distTo[w] > distTo[v] + directedEdge.weight()) {
                distTo[w] = distTo[v] + directedEdge.weight();
                edgeTo[w] = directedEdge;
                if (pq.contains(w)) {
                    pq.change(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
}
