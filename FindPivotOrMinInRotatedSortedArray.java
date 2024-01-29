// Time Compexity - O(log N)
// Space Complexity - O(1)

// Constraints:
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// All the integers of nums are unique.
// nums is sorted and rotated between 1 and n times.

public class FindPivotOrMinInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                if (nums[low] < nums[high]) { // [11,12,13,14,15]
                    return nums[low];
                }
                int mid = low + (high - low) / 2;
                if ((mid == 0 || nums[mid] < nums[mid - 1])
                        && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                    return nums[mid];
                }
                // [2,1] = Equality
                if (nums[low] <= nums[mid]) { // Sorted subarray
                    low = mid + 1; // Move towards unsorted array
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}
