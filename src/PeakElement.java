// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Apply Binary search. After calculating mid, check if
 * mid > mid + 1. If so, then make it right index. Now,
 * the goal is to make the left = right if the current
 * value is the peak element. So, if the mid is not 
 * > mid + 1, then move left to mid + 1. Once left = right,
 * return left. 
 *
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}