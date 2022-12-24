// Time Complexity  : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (https://leetcode.com/problems/find-peak-element/)
// Any problem you faced while coding this : no

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid])
                    && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid < n && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}