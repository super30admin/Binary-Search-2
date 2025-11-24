// I apply binary search and compare mid with its next element to determine the direction of increasing slope.
// If nums[mid] < nums[mid+1], I move right because a peak must exist on that rising slope.
// Otherwise, I move left because the peak is on the left side or at mid itself.

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;   // go right
            } else {
                right = mid;      // go left or stay
            }
        }

        return left; // or right (same position)
    }
}

