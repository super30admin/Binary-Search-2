// Time Complexity  : O(2 logn) will be O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
// Any problem you faced while coding this : no

class FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int left = binarySearchLeft(nums, low, high, target);
        if (left == -1) return new int[]{-1, -1};
        int right = binarySearchRight(nums, left, high, target);
        return new int[]{left, right};
    }

    private int binarySearchLeft(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
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

    private int binarySearchRight(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
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