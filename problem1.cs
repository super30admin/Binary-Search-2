public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        int first = FindBound(nums, target, true);
        int last = FindBound(nums, target, false);
        return new int[] { first, last };
    }

    private int FindBound(int[] nums, int target, bool isFirst) {
        int left = 0, right = nums.Length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
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
