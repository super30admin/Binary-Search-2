// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially had confusion about when to shift left vs right pointers

// Your code here along with comments explaining your approach in three sentences only:
// I used binary search to find the minimum element in a rotated sorted array without duplicates.
// If the array section is sorted (`nums[l] <= nums[r]`), then `nums[l]` is the minimum.
// Otherwise, I narrow the search space based on the mid element and its relationship with the left and right bounds.

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int l = 0;
        int r = n;

        while (l <= r) {
            // If current window is sorted, the smallest element is at l
            if (nums[l] <= nums[r]) return nums[l];

            int mid = l + (r - l) / 2;

            // Check if mid is the pivot point (minimum element)
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // If mid element is greater than or equal to left, then the left part is sorted
            if (nums[mid] >= nums[l]) {
                l = mid + 1; // Move to the unsorted right part
            } else {
                r = mid - 1; // Move to the unsorted left part
            }
        }

        return -1; // Should not reach here for valid rotated sorted array input
    }
}
