// Time Complexity: O(log n)
// Space Complexity: O(1)

// 1: We perform binary search twice to find both the first and last index
// 2: To find the first index, we move the high pointer to mid-1 and then continue binary search as usual
// 3: To find the last index, the move the low pointer to mid+1 before continuing binary search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length - 1;
        int first = binarySearchFirst(nums, target, 0, size);

        if (first == -1) return new int[]{-1, -1};

        int last = binarySearchLast(nums, target, first, nums.length - 1);

        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
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

    private int binarySearchLast(int[] nums, int target, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == size || nums[mid + 1] != target) {
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
}