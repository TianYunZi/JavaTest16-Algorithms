package chapter04.depth.first.search;

import chapter04.graph.data.type.GraphDataType;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 使用深度优先搜索查找图中的路径.
 */
public class DepthFirstPaths {

    private boolean[] marked; // 从这个顶点上调用过dfs()了吗

    private int[] edgeTo; // 从起点到一个顶点已知路径上的最后一个顶点

    private final int s; // 起点

    public DepthFirstPaths(GraphDataType graphDataType, int s) {
        marked = new boolean[graphDataType.V()];
        edgeTo = new int[graphDataType.V()];
        this.s = s;
        dfs(graphDataType, s);
    }

    private void dfs(GraphDataType graphDataType, int v) {
        marked[v] = true;
        for (int w : graphDataType.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graphDataType, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Deque<Integer> path = new LinkedList<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
