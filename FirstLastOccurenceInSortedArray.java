/*
* Approach:
*  1. Apply binary search to array to find first occurrence
* 
*  2. Again apply binary search in the range of first occurence - high,
        to find last occurrence
* 
    why we are not applying binary search on both sides?
        if we apply binary search on both sides, it becomes linear search.

*  3. return first and last occurrence.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(logN) + O(logN) == O(logN)
* 
* Space Complexity: O(1)
* 
*/

public class FirstLastOccurenceInSortedArray {
    private int binarySearchLeft(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1])
                    return mid;

                else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int binarySearchRight(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == target) {
                if (mid + 1 == nums.length || nums[mid] < nums[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeft(nums, 0, nums.length - 1, target);

        if (left == -1)
            return new int[] { -1, -1 };

        int right = binarySearchRight(nums, left, nums.length - 1, target);

        return new int[] { left, right };
    }
}
