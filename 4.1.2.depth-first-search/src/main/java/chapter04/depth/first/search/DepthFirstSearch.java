package chapter04.depth.first.search;

import chapter04.graph.data.type.GraphDataType;

/**
 * 深度优先搜索.
 */
public class DepthFirstSearch {

    private boolean[] marked;

    private int count;

    public DepthFirstSearch(GraphDataType graphDataType, int s) {
        marked = new boolean[graphDataType.V()];
        dfs(graphDataType, s);
    }

    private void dfs(GraphDataType graphDataType, int v) {
        marked[v] = true;
        count++;
        for (int w : graphDataType.adj(v)) {
            if (!marked[w]) {
                dfs(graphDataType, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
