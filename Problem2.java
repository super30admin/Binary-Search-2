// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Time Complexity : O(log n) where n is the number of elements in the input array;
// Space Complexity : O(1);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Approach : We will use binary search to find the minimum element in the rotated sorted array.
 *            We will check if the middle element is the minimum element by comparing it with its neighbors.
 *            If it is not the minimum element, we will check if the left half of the array is sorted or not. 
 *            If it is sorted, then the minimum element must be in the right half of the array.
 *            If it is not sorted, then the minimum element must be in the left half of the array. 
 *            We will continue this process until we find the minimum element.
 */

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while (low <= high){
            if(nums[low] < nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n-1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            } else if( nums[low] <= nums[mid]) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}