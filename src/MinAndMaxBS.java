// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * This is same as binary search except with 2 conditions.
 * to find left index, apply same BS approach except that 
 * whenever the target is found, move the right index to 
 * right - 1.
 * To find right index, whenever the target is found, move
 * the left index + 1.
 *
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftSearch(nums, target);
        int right = rightSearch(nums, target);
        return new int[] {left, right};
    }

    public int leftSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] >= target) {
                ans = nums[mid] == target ? mid : ans;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int rightSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] <= target) {
                ans = nums[mid] == target ? mid : ans;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}