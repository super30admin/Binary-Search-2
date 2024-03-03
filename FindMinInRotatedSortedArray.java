// Time Complexity : O(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Used binary search to search the smallest element that has a bigger element on its left, in a rotated sorted array.

// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        if (nums == null && nums.length == 0)
            return -1; // null check

        int low = 0, high = nums.length - 1, mid = 0;

        while (low <= high) {
            if (nums[low] <= nums[high])
                return nums[low]; // sorted array in ascending order

            mid = low + (high - low) / 2;
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[low] > nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
