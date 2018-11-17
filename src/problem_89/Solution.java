package problem_89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>(1<<n);
        result.add(0);
        for(int k=1;k<=n;k++){
            for (int i=result.size()-1;i>=0;i--){
                result.add(result.get(i)|(1<<(k-1)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result=new Solution().grayCode(2);
        for (Integer i:result){
            System.out.println(i);
        }
    }
}
