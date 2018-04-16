package chapter04.directed.cycle;

import chapter04.digrapg.data.type.Digraph;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstOrder {

    private boolean[] marked;

    private Deque<Integer> pre; // 所有顶点的前序排列

    private Deque<Integer> post; // 所有顶点的后序排列

    private Deque<Integer> reversePost; // 所有顶点的逆后序排列

    public DepthFirstOrder(Digraph digraph) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new LinkedList<>();
        marked = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        pre.add(v);
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}

