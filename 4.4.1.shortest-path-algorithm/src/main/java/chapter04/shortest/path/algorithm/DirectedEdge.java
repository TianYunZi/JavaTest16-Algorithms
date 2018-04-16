package chapter04.shortest.path.algorithm;

/**
 * 加权有向边的数据类型.
 */
public class DirectedEdge {

    private final int v; // 边的起点

    private final int w; // 边的终点

    private final double weight; // 边的权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Double weight() {
        return weight;
    }

    public Integer from() {
        return v;
    }

    public Integer to() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
