// Time Compexity - O(log N)
// Space Complexity - O(1)

// Constraints:
// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
// nums is a non-decreasing array.
// -10^9 <= target <= 10^9

public class FirstAndLastSortedArray {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid = low + (high - low) / 2;
            int firstIndex = -1, lastIndex = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        firstIndex = mid;
                        break;
                    }
                }
                if (nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (low > high) {
                return new int[] { firstIndex, lastIndex };
            }

            low = mid;
            high = nums.length - 1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        lastIndex = mid;
                        return new int[] { firstIndex, lastIndex };
                    }
                }
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return new int[] { firstIndex, lastIndex };
        }
    }
}
