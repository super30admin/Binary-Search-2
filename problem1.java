// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/**
 * we find the first occurrence of the element by comparing the element with its left neighbor via doing binary search in whole array
 * Then we find the last occurrence of the element by comparing the element with its right neighbor via doing binary search between first occurrence and end of array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int n = nums.length;
        //find the first occurrence
        int first = findFirstOccurrence(nums, 0, n - 1, target);
        // first match was not found so target doesn't exist
        if (first == -1) return new int[]{-1, -1};
        int second = findSecondOccurrence(nums, first, n - 1, target);

        return new int[]{first, second};
    }

    private int findFirstOccurrence(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // match found
            if (nums[mid] == target) {
                // if match at first index or the first occurrence within array
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                // reject the right half to find the first occurrence
                else {
                    high = mid - 1;
                }
            }
            // reject the right half to find the first occurrence
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            // reject the left half to find the first occurrence
            else {
                low = mid + 1;
            }
        }

        // match not found
        return -1;
    }

    private int findSecondOccurrence(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // match found
            if (nums[mid] == target) {
                // if match at last index or last occurrence within array
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                }
                // reject the left half to find the last occurrence
                else {
                    low = mid + 1;
                }
            }
            // reject the left half to find the last occurrence
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            // reject the right half to find the last occurrence
            else {
                high = mid - 1;
            }
        }

        // unreachable since we found the first match
        return -1;
    }

}