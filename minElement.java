// Time Complexity : O( logn), n is the length of the array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * In a rotated array, one side always sorted.
 * Check the sorted array condition, change the start pointer
 * compare the previous and after elements of mid element and return the result
 */
class Solution {
    public int findMin(int[] nums) {

        // check base case
        if (nums.length == 0 || nums == null)
            return -1;

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] < nums[end])
                return nums[start];

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}