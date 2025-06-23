class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Case when the subarray is already sorted
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            // Check if mid is the pivot (minimum element)
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Decide which half to discard
            if (nums[low] <= nums[mid]) {
                // Left half is sorted, so min must be in right half
                low = mid + 1;
            } else {
                // Right half is unsorted, so min must be there
                high = mid - 1;
            }
        }
        return -1;
    }
}