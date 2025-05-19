// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[] { -1, -1 };
        if (nums.length == 0)
            return arr;

        arr[0] = getIndex(nums, target, true);
        arr[1] = getIndex(nums, target, false);

        return arr;
    }

    int getIndex(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1;  // Search left
                } else {
                    left = mid + 1;   // Search right
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }
}