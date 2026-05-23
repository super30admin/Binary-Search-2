// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Time Complexity : O(log n) where n is the number of elements in the input array;
// Space Complexity : O(1);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach : We will use binary search to find the first and last positions of the target element in the input array.
 *            We will first find the first occurrence of the target element using binary search.
 *            Then we will find the last occurrence of the target element using binary search.
 *            We will return the first and last positions of the target element in the input array.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = binarySearchFirst(nums, target, 0, nums.length - 1);

        if (first == -1)
            return new int[] { -1, -1 };
        int last = binarySearchLast(nums, target, first, nums.length - 1);
        return new int[] { first, last };
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high) {
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
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
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                if (mid == nums.length -1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (target < nums[mid]) {

                

                high = mid - 1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }
}

