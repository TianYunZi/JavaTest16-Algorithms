package chapter04.minimal.spanning.tree.algorithm;

/**
 * 带权重的边的数据类型.
 */
public class Edge implements Comparable<Edge> {

    private final Integer v; // 顶点之一

    private final Integer w; // 另一个顶点

    private final double weight; // 边的权重

    public Edge(Integer v, Integer w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Double weight() {
        return weight;
    }

    public Integer eithter() {
        return v;
    }

    public Integer other(Integer vertex) {
        if (vertex.equals(w)) {
            return v;
        } else if (vertex.equals(v)) {
            return w;
        } else {
            throw new RuntimeException("Inconsistent edge");
        }
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) {
            return -1;
        } else if (this.weight() > that.weight()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
