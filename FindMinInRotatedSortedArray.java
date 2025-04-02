public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            if (nums[low] <= nums[mid]) { // left sorted
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

/**
 * Key-Note: The minimum element always lies in the unsorted part of the rotated array.
 * Approach: Use binary search to identify the unsorted region and narrow down to the minimum.
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
