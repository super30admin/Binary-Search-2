class Solution {

    // Binary search to find the first occurrence of target
    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
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

    // Binary search to find the last occurrence of target
    private int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};

        int n = nums.length;
        if (target < nums[0] || target > nums[n - 1]) return new int[] {-1, -1};

        int firstIdx = binarySearchFirst(nums, 0, n - 1, target);
        if (firstIdx == -1) return new int[] {-1, -1};

        int lastIdx = binarySearchLast(nums, firstIdx, n - 1, target);
        return new int[] {firstIdx, lastIdx};
    }
}