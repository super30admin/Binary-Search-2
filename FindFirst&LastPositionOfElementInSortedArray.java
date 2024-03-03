// Time Complexity : O(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Used binary search to search for the first and last index with the target value.

// Your code here along with comments explaining your approach
class Solution {
    private int bs1(int[] nums, int target, int low, int high, int mid) { // binary search function to search for the
                                                                          // first index

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target)
                    return mid;
                else
                    high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int bs2(int[] nums, int target, int low, int high, int mid) { // binary search function to search for the
                                                                          // first index

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target)
                    return mid;
                else
                    low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        int low = 0, high = nums.length - 1, mid = 0;
        int start = bs1(nums, target, low, high, mid);
        int end = bs2(nums, target, low, high, mid);
        return new int[] { start, end };
    }
}