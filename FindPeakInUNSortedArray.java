// Time Compexity - O(log N)
// Space Complexity - O(1)

// Constraints:
// 1 <= nums.length <= 1000
// -2^31 <= nums[i] <= 2^31 - 1
// nums[i] != nums[i + 1] for all valid i.

public class FindPeakInUNSortedArray {
    class Solution {
        public int findPeakElement(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                    return mid;
                }
                if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}
