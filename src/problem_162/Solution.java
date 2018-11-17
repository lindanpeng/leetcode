package problem_162;

public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length- 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return right;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{7,8,9,2,5,6,7}));
    }
}
