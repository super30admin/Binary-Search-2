// Time Complexity : log(n) + log(m) ( log(m) becuase on the right part will wont be doing the binary search from 0 to N, but we can ignore log m becasue only higher order term matter)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes i bit, how we are reaching in first index and the last index is a bit compusing to me still but i'll know how we do it in terms of theory code is were i am stipping a bit

/*
 * Approach
 * in order to find the first and the last index we are basically doing the binary serach 2 times, one is to find the starts index of the number
 * and then second time to find the index where the element occurs for the last time.
 * 
 * we reduce the search space for the last element by using the first occurance index as low  
 * 
 */

class Solution {
    public int rightbinarysearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int leftbinarysearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        if (target > nums[high]) {
            return new int[] { -1, -1 };
        }
        if (target < nums[0]) {
            return new int[] { -1, -1 };
        }
        int inital = leftbinarysearch(nums, target, low, high);
        int last = rightbinarysearch(nums, target, inital, high);
        return new int[] { inital, last };

    }
}