package chapter04.directed.depth.first.search;

import chapter04.digrapg.data.type.Digraph;

/**
 * 有向图的可达性.
 */
public class DirectedDepthFirstSearch {

    private boolean[] marked;

    public DirectedDepthFirstSearch(Digraph digraph, int s) {
        marked = new boolean[digraph.V()];
        dfs(digraph, s);
    }

    public DirectedDepthFirstSearch(Digraph digraph, Iterable<Integer> source) {
        marked = new boolean[digraph.V()];
        for (int s : source) {
            if (!marked[s]) {
                dfs(digraph, s);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
