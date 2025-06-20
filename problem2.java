// Time Complexity : O(log n) as we reduce the search space by half in every iteration.
// Space Complexity : O(1) as no extra space is used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: At every point, either the left half is sorted or the right half is sorted. 
// If the left half is sorted, we move forward to the right half as we know the array is rotated. Because, in the right there is a point from which the array gets rotated, so the minimum will be there.
// Since left is sorted, there will be a point in right half where the minimum is lying, so we move left ahead. 
// Else, the minimum is in the left half, so we move right behind.


class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 1 || nums[right] > nums[0]) return nums[0];
        while (left<=right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[left]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}