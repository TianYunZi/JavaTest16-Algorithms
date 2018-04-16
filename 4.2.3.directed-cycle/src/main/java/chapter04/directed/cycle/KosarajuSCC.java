package chapter04.directed.cycle;

import chapter04.digrapg.data.type.Digraph;

/**
 * 计算强连通分量的Kosaraju算法.
 */
public class KosarajuSCC {

    private boolean[] marked; // 已访问过的顶点

    private Integer[] id; // 强连通分量的标识符

    private Integer count; // 强连通分量的数量

    public KosarajuSCC(Digraph digraph) {
        marked = new boolean[digraph.V()];
        id = new Integer[digraph.V()];
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph.reverse());
        for (int s : depthFirstOrder.reversePost()) {
            if (!marked[s]) {
                dfs(digraph, s);
                count++;
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v].equals(id[w]);
    }

    public Integer id(int v) {
        return id[v];
    }

    public Integer count() {
        return count;
    }
}
