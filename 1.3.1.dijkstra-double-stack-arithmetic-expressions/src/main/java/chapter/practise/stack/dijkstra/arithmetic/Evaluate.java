package chapter.practise.stack.dijkstra.arithmetic;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class Evaluate {

    public static void main(String[] args) {
        String expression = "(1+((2+3)*(4*5)))";
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        if (StringUtils.isNotBlank(expression)) {
            char[] character = expression.toCharArray();
            for (int i = 0; i < character.length; i++) {
                if (character[i] == '(') {
                    ;
                } else if (character[i] == '+') {
                    ops.push(character[i]);
                } else if (character[i] == '-') {
                    ops.push(character[i]);
                } else if (character[i] == '*') {
                    ops.push(character[i]);
                } else if (character[i] == '/') {
                    ops.push(character[i]);
                } else if (character[i] == ')') {
                    Character operator = ops.pop();
                    Double val = vals.pop();
                    if (operator == '+') {
                        val = vals.pop() + val;
                    } else if (operator == '-') {
                        val = vals.pop() - val;
                    } else if (operator == '*') {
                        val = vals.pop() * val;
                    } else if (operator == '/') {
                        val = vals.pop() / val;
                    }
                    vals.push(val);
                } else {
                    vals.push(Double.parseDouble(String.valueOf(character[i])));
                }
            }
        }
        System.out.println("计算结果: " + vals.pop());
    }
}
