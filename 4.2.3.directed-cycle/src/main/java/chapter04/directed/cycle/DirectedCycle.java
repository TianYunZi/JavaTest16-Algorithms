package chapter04.directed.cycle;

import chapter04.digrapg.data.type.Digraph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 寻找有向环.
 */
public class DirectedCycle {

    private boolean[] marked;

    private Integer[] edgeTo;

    private Deque<Integer> cycle; // 有向环中的所有顶点(如果存在)

    private boolean[] onStack; // 递归调用的栈上的所有顶点

    public DirectedCycle(Digraph digraph) {
        onStack = new boolean[digraph.V()];
        edgeTo = new Integer[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]) {
                cycle = new LinkedList<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
