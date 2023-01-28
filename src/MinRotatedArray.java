// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Similar to Binary search. After finding the mid,
 * check if it is < previous element if so, return mid,
 * else if it is > next element, return next element.
 * If not, then check if mid > 0th element. If so,
 * that means we are still in the sorted part of the array.
 * So, we have to move to the left. Else move to the right.
 *
 */
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums[0] < nums[nums.length - 1])
            return nums[0];
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if(nums[mid] < nums[mid - 1])
                return nums[mid];
            else if(nums[0] < nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return Integer.MAX_VALUE;
    }
}