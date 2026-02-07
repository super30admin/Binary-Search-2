// Binary Search O(log n) time, O(1) space
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            // check mid > both neighbors, then it is the peak
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            else if (nums[mid+1] > nums[mid]) { // always keep climbing
                left = mid + 1; // guaranteed to get peak when we climb
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
