// Time Complexity : O(log(n))
// Space Complexity : O(1) 
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        // array with only one element
        if (high == 0) {
            return nums[0];
        }

        while (low <= high) {
            // if the array is sorted, directly return element at low
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
             (mid == nums.length -1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}