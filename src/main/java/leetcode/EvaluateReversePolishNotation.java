package leetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author Flaming
 * @date 2019/6/3 23:57
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if(null == tokens || 0 == tokens.length){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            switch(token){
                case "+": case "-": case "*": case "/":
                    if(stack.size() < 2){
                        return 0;
                    }
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(cal(num1, num2, token));
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }

    public int cal(int num1, int num2, String token){
        switch(token){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return -1;
    }

}
