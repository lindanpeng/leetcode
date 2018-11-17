package problem_274;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        if (citations==null||citations.length<=0)
            return 0;
        Arrays.sort(citations);
        for (int i=citations.length-1;i>=0;i--){
            if (citations[i]<citations.length-i){
                return citations.length-i-1;
            }
        }
        return citations.length;
    }
    public static void main(String[] args) {

    }
}
