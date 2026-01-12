// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just needed to observe increasing and decreasing slope.


// Your code here along with comments explaining your approach in three sentences only
// We use binary search and check whether the middle element is in increasing or decreasing slope.
// If nums[mid] is less than nums[mid+1], then a peak must exist on the right side, otherwise on the left side including mid.
// We keep shrinking the range until low equals high, which gives the index of a peak element.

class Solution {
    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
