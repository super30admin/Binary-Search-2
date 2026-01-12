// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just had to decide which side of array is sorted.


// Your code here along with comments explaining your approach in three sentences only
// We use binary search and compare the middle element with the last element to find which side contains the minimum.
// If mid is greater than high, the minimum must be on the right side, otherwise it is on the left side including mid.
// We keep shrinking the range until low meets high, which gives the minimum element.

class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
