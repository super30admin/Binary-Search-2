// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach:
We perform binary search twice — first to find the first occurrence and then to find the last occurrence of the target. 
In the first search, once we find the target, we continue searching on the left to ensure it is the first index, and similarly search right for the last occurrence. 
If the target is not found, we return [-1, -1]; otherwise, we return the indices of first and last occurrence.
*/

class Solution {

    private int binarySearchFirst(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirst(nums, target, 0, nums.length - 1);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = binarySearchLast(nums, target, first, nums.length - 1);

        return new int[]{first, last};
    }
}