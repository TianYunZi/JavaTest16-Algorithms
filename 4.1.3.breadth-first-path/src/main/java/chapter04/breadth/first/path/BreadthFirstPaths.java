package chapter04.breadth.first.path;

import chapter04.graph.data.type.GraphDataType;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索
 */
public class BreadthFirstPaths {

    private boolean[] marked; // 到达该顶点的最短路径已知吗

    private int[] edgeTo; // 到达该顶点已知路径上的最后一个顶点

    private final int s;

    public BreadthFirstPaths(GraphDataType graphDataType, int s) {
        marked = new boolean[graphDataType.V()];
        edgeTo = new int[graphDataType.V()];
        this.s = s;
        bfs(graphDataType, s);
    }

    private void bfs(GraphDataType graphDataType, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true; // 标记起点
        queue.add(s); // 将它加入队列
        while (!queue.isEmpty()) {
            int v = queue.remove(); // 从队列中删去下一个顶点
            for (int w : graphDataType.adj(v)) {
                if (!marked[w]) { // 对于每一个未被标记的相邻顶点
                    edgeTo[w] = v; // 保存最短路径的最后一条边
                    marked[w] = true; // 标记它，因为最短路径已知
                    queue.add(w); // 将它添加到队列
                }
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
