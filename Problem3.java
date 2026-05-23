// https://leetcode.com/problems/find-peak-element/
// Time Complexity : O(log n) where n is the number of elements in the input array;
// Space Complexity : O(1);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach : We will use binary search to find the peak element in the input array.
 *            We will check if the middle element is the peak element by comparing it with its neighbors.
 *            If it is not the peak element, we will check if the right half of the array is sorted or not. 
 *            If it is sorted, then the peak element must be in the left half of the array.
 *            If it is not sorted, then the peak element must be in the right half of the array. 
 *            We will continue this process until we find the peak element.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int high = n - 1;
        int low = 0;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}