class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (nums == null)
            return new int[] { -1, -1 };
        int low = 0, high = n - 1;
        int start = -1, end = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    start = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (start == -1) {
            return new int[] { -1, -1 };
        }
        low = start;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid + 1 == n || nums[mid] < nums[mid + 1]) {
                    end = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { start, end };
    }
}
