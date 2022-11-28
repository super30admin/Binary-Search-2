// Time Complexity : O( logn), n is the length of the array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * to find peak element we need to move to the increasing side, so that we will get the peak element at last index or any other index.
 * compare the previous and after elements of mid element and return the result
 */
class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 0 || nums == null)
            return -1;

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}