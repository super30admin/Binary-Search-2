// Time Complexity: O(log n)
// Space Complexity: O(1)

// Approach: rule out edge case if arrays is empty, return [-1, -1]
// findFirst occurance of target by binarySearch, and continue checking on the left. If it is equal to target, the first occurance lies further to the left. Continue //binary search on left.
// If it returns -1, that means target does not exist in array, so set -1 to lastIndex as well. Else apply same approach, this time look to the right and continue searching on right if necessary

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Edge case, if array is empty
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int firstIndex = findFirstIndex(nums, target);

        int lastIndex = firstIndex != -1 ? findLastIndex(nums, target) : -1;

        return new int[] {firstIndex, lastIndex};

    }

    private int findFirstIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2; // to prevent integer overflow
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findLastIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2; // to prevent integer overflow
            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}