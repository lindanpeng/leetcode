package problem_150;

import java.util.Stack;

public class Solution {
    public boolean isOperator(String token){
        return token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/");
    }
    public int operate(int a,int b,String operator){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 0;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if (isOperator(tokens[i])){
                int b=stack.pop();
                int a=stack.pop();
                int result=operate(a,b,tokens[i]);
                stack.push(result);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

}
