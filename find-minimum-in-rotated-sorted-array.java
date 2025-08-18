// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences
// Appraoch:
// Check if current window is sorted: if nums[low] ≤ nums[high], then nums[low] is the minimum.
// Binary search pivot: compute mid, and if nums[mid] > nums[high], drop the left half (low = mid + 1); otherwise drop the right half (high = mid).
// Terminate when low == high, then nums[low] is the minimum.

class Solution {
    public int findMin(int[] nums) {
        // single-element array
        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // if already sorted, first element is min
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low)/2;
            // if mid is pivot (smaller than neighbors)
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            // left half sorted → pivot in right half
            else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            // otherwise pivot in left half
            else {
                high = mid - 1;
            }
        }
        // should never reach here for valid input
        return 123;
    }
}