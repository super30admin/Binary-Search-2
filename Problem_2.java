// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Use binary search to find the minimum element in a rotated sorted array.
// Compare the middle element with the last element to decide which side to search.
// Keep narrowing the range until low meets high, then return nums[low].


class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) { // right sorted range
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}