// I used Binary Search to find the minimum element (pivot point) in a rotated sorted array ( i also wanted to tackle the index as well).
// The key idea is to compare the mid element with the last element to determine the unsorted part
// because the smallest element lies in the unsorted portion of the rotated array.

// Time Complexity : O(log n) — binary search halves the search space
// Space Complexity : O(1) — constant extra space used
// Did this code successfully run on Leetcode : Yes

import java.util.*;

class MinSortRotated {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int pivot = -1;

        // Case 1: The array is not rotated
        if (nums[low] < nums[high]) return nums[low];

        // Binary search to find the smallest element
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid is less than or equal to last element, minimum lies on left (including mid)
            if (nums[mid] <= nums[nums.length - 1]) {
                pivot = mid;          // Potential minimum
                high = mid - 1;       // Keep searching left
            } else {
                low = mid + 1;        // Minimum must be in right half
            }
        }

        return nums[pivot];  // Return the minimum element found
    }
}
