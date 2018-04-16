package chapter04.directed.cycle;

import chapter04.digrapg.data.type.Digraph;

/**
 * 拓扑排序.
 */
public class Topological {

    private Iterable<Integer> order; // 顶点的拓扑排序

    public Topological(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
            order = depthFirstOrder.reversePost();
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
