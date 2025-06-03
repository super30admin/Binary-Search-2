// Time Complexity : O(log n) + O(log n) = O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// we use two modified binary searches to find the starting and ending position of a given target value in a sorted array:
// 1. Find the First Occurrence:
//  When we find a match, we check if it's the first occurrence by verifying if it's the first index (`mid == 0`) or  if the previous element is different (`nums[mid - 1] != target`).
//  If it’s not the first occurrence, we continue the search in the left half of the array.
//
// 2. Find the Last Occurrence:
//   Once we have found the first occurrence, we search for the last occurrence starting from that index to the end of the array.
//   We again use binary search and verify if it’s the last occurrence by checking if it’s the last index (`mid == n - 1`) or if the next element is different (`nums[mid + 1] != target`).
//   If it’s not the last occurrence, we continue the search in the right half of the array.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        // If the array is empty, return [-1, -1]
        if (n == 0) return new int[]{-1, -1};

        // Array to store the result
        int[] result = new int[]{-1, -1};

        // Find the first occurrence of the target
        result[0] = binarySearchFirst(nums, target, 0, n - 1);

        // If the target is not found at all, return [-1, -1]
        if (result[0] == -1) return result;

        // Find the last occurrence of the target
        result[1] = binarySearchLast(nums, target, result[0], n - 1);
        return result;
    }

    // Helper function to find the first occurrence of the target
    private int binarySearchFirst(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // If mid is at the beginning or the previous element is different, return mid
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    // Else keep searching in the left half
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1; // Move left
            } else {
                low = mid + 1; // Move right
            }
        }
        return -1; // Not found
    }

    // Helper function to find the last occurrence of the target
    private int binarySearchLast(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // If mid is at the end or the next element is different, return mid
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    // Else keep searching in the right half
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1; // Move left
            } else {
                low = mid + 1; // Move right
            }
        }
        return -1; // Not found
    }
}
