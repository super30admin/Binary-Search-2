// Time Complexity : O(log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
class firstLastIndex {

    private int findStartIndex(int[] nums, int low, int high, int target) {

        int n = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
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

    private int findEndIndex(int[] nums, int low, int high, int target) {

        int n = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == n - 1 || nums[mid + 1] > nums[mid]) {
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

        int n = nums.length;

        if (n == 0 || target < nums[0] || target > nums[n - 1]) {
            return new int[] { -1, -1 };
        }

        int startIndex = findStartIndex(nums, 0, n - 1, target);

        if (startIndex == -1) {
            return new int[] { -1, -1 };
        }

        int endIndex = findEndIndex(nums, startIndex, n - 1, target);

        return new int[] { startIndex, endIndex };
    }
}