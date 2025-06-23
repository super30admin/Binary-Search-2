class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak
            boolean leftOK = (mid == 0 || nums[mid] > nums[mid - 1]);
            boolean rightOK = (mid == n - 1 || nums[mid] > nums[mid + 1]);

            if (leftOK && rightOK) {
                return mid;
            } 
            // If left neighbor is greater, search left half
            else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            } 
            // Otherwise, search right half
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}