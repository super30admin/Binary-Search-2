// Time Complexity : O(log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

class findMinRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            if ((mid != 0 && nums[mid] < nums[mid - 1]) &&
                    (mid != nums.length -1 && nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }

            if (nums[low] <= nums[mid]) {
                // left is sorted
                low = mid + 1;
            } else {
                // right is sorted
                high = mid - 1;
            }
        }
        return -1;
    }
}