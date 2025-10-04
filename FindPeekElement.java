public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // To avoid overflow

            // Check if mid is a peak element
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
                (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // If the right neighbor is greater, peak is on the right half
            else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            // If the left neighbor is greater, peak is on the left half
            else {
                right = mid - 1;
            }
        }

        return -1;  // This line should never be reached because a peak will always be found.
    }
}


//Time Complexity : O(log n)
//Space Complexity : O(1)