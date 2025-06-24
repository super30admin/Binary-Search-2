/* PROBLEM DESCRIPTION:- 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
// Time Complexity :O(logn)
// Space Complexity :O(1)
/* Approach:
Use two modified binary searches to find the first and last positions of the target in the sorted array.
The first binary search (`binarySearchFirst`) finds the leftmost (first) occurrence of the target.
The second binary search (`binarySearchLast`) finds the rightmost (last) occurrence of the target.*/
class Range {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };// empty array case
        }
        // Find the first occurrence of target
        int first = binarySearchFirst(nums, target);
        // If target is not found at all, return [-1, -1]
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        // Find the last occurrence of target
        int last = binarySearchLast(nums, target);
        // Return the range [first, last]
        return new int[] { first, last };
    }

    // Binary search for the first occurrence of target
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// Prevent overflow
            // Checking if mid is first occurance
            if (nums[mid] == target) {
                // If mid is at lower boundary or the element before mid is not target
                if ((mid == low) || nums[mid - 1] != nums[mid]) {
                    return mid;// then mid is the first occurance
                }
                // Keep searching towards the left (lower indices)
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;// Target is in right half
            } else {
                high = mid - 1;// Target is in left half
            }
        }
        return -1;// Target not found
    }

    // Method to find the last occurrence (right boundary) of the target
    private int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // Standard binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Checking if mid is the last occurrence:
            if (nums[mid] == target) {
                // - If mid is at high boundary or the element after mid is not target
                if ((mid == high) || nums[mid + 1] != nums[mid]) {
                    return mid;// then mid is the last occurance
                }
                // Keep searching towards the right (higher indices)
                low = mid + 1;
            } else if (target > nums[mid]) {
                // Target is in right half
                low = mid + 1;
            } else {
                // Target is in left half
                high = mid - 1;
            }
        }
        // Target not found
        return -1;
    }
}