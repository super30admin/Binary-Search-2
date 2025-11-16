// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Implement using two binary searches
// Time complexity: O(logN)
// Space complexity: O(1) - no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = binarySearchForFirstIndex(nums, target, 0, nums.length - 1);
        if (firstIndex == -1) {
            return new int[] {-1, -1};
        }
        int lastIndex = binarySearchForLastIndex(nums, target, firstIndex, nums.length - 1);
        return new int[] {firstIndex, lastIndex};
    }

    private int binarySearchForFirstIndex(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid - 1 < 0 || nums[mid - 1] != nums[mid])) {
                return mid;
            } else if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchForLastIndex(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid + 1 == nums.length || nums[mid + 1] != target)) {
                return mid;
            } else if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}