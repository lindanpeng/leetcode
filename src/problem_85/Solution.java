package problem_85;

import java.util.Stack;

public class Solution {
    public int largestHistogramArea(int[] heights){
        //保存索引
        Stack<Integer> stack=new Stack<>();
        int max=0,top;
        for (int i=0;i<=heights.length;i++){
            int h=(i==heights.length?0:heights[i]);
            if (stack.empty()||h>=heights[stack.peek()]){
                stack.push(i);
            }
            else{
                top=stack.pop();
                max=Math.max(max,heights[top]*(stack.empty()?i:(i-1-stack.peek())));
                i--;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int result=new Solution().largestHistogramArea(new int[]{2,3,5,3,1});
        System.out.println(result);
    }
}
