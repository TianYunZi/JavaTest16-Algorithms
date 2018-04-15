package chapter04.symbol.graph;

import chapter04.graph.data.type.GraphDataType;
import chapter04.graph.data.type.ST;

/**
 * 符号表.
 */
public class SymbolGraph {

    private ST<String, Integer> st; // 符号名 索引

    private String[] keys; // 索引 符号名

    private GraphDataType graphDataType; // 图

    public SymbolGraph(String stream, String sp) {

    }
}
