// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// Approach:
// Perform two binary searches—one to find the first occurrence of target, one to find the last.
// In each search, narrow window until hit the boundary where nums[mid] equals target but its neighbor differs.
// Return [-1,-1] early if the first search fails.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }

        int first = binarySearchFirst(nums, target);
        if (first == -1) {
            return new int[] {-1, -1};
        }

        int last = binarySearchLast(nums, target);
        return new int[] {first, last};
    }

    // Find leftmost (first) index of target
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                }
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if ((mid == nums.length - 1) || (nums[mid] != nums[mid + 1])) {
                    return mid;
                }
                low = mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}