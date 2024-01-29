// Time Compexity - O(log N)
// Space Complexity - O(1)

// Constraints:
// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
// nums is a non-decreasing array.
// -10^9 <= target <= 10^9

public class FirstAndLastSortedArray {
    class Solution {
        private int searchFirstIndex(int[] nums, int low, int high, int target) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                }
                if (target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        private int searchLastIndex(int[] nums, int low, int high, int target) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                }
                if (target >= nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        public int[] searchRange(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int firstIndex = searchFirstIndex(nums, low, high, target);
            if (firstIndex == -1) {
                return new int[] { -1, -1 };
            }
            int lastIndex = searchLastIndex(nums, firstIndex, high, target);

            return new int[] { firstIndex, lastIndex };
        }
    }
}
