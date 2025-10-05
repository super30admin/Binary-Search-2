// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Approach
 * idea here is to find the number that a peak meaning the number before and after that number are smaller then that number
 * even though it is a sorted array we can apply binary search becasue of the conditiion that nums[i] != nums[i+1]
 * we move the search space where we find the greater element when comparing elements
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 999;
    }
}