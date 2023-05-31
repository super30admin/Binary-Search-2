class Solution {
    private int findLeftPosition(int[] nums, int low, int high, int target) {
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findRightPosition(int[] nums, int low, int high, int target) {
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int left = findLeftPosition(nums, low, high, target);
        int right = findRightPosition(nums, low, high, target);
        return new int[] { left, right };

    }
}