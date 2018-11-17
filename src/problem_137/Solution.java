package problem_137;

public class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for (int i=0;i<32;i++){
            int s=0;
            for (int j=0;j<nums.length;j++){
                s+=nums[j]>>i&1;
            }
            s=s%3;
            result^=s<<i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={2,2,3,2};
        int result=new Solution().singleNumber(arr);
        System.out.println(result);

    }
}
