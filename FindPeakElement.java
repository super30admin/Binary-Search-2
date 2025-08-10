
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        if (high == 0) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // mid is greater than neighbors
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            if (mid == 0 || nums[mid] > nums[mid - 1]) {
                low = mid + 1;
                
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}