// Time Complexity: O(log(N))
// Space Complexity: O(1)
// Did this run on Leetcode? : Yes
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // Only one element, return it's index
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) / 2);

            // If I am walking downwards, peak went behind me
            // hence discard right half
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } 
            // If I am walking upwards, peak is yet to arrive.
            // Hence discard left half
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}