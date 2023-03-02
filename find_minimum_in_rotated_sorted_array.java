// Time Complexity: O(log(N))
// Space Complexity: O(1)
// Did this run on Leetcode? : Yes
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // If only one element is present or if the entire aray is sorted
        // in strictly increasing order
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            // Dip found at 'mid -> mid + 1'
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } 
            // Dip found at 'mid - 1 -> mid'
            else if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } 
            // Left array is sorted, dip must be present in right unsorted array
            else if (nums[mid] > nums[0]) {
                left = mid + 1;
            } 
            // Right array is sorted, dip must be present in left unsorted array
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}