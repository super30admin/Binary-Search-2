// Time = log(n)
// Search lower bound using one binary search. Find mid check if the mid is greater than the mid-1 otherwise keep moving left.
// Another binary search for finding right index.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] defaultArray = {-1, -1};
        if (nums == null || nums.length == 0) {
            return defaultArray;
        }
        int[] result = {findLowerIndex(nums, target), findHigherIndex(nums, target)};

        return result;
    }

    private int findLowerIndex(final int[] nums, final int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findHigherIndex(final int[] nums, final int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] > nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}