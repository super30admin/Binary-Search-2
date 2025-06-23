// This solution incorporates the Binary Search Logic to find minimum element in rotated sorted array
// Time complexity: O(log n) <-- checks only half the array at a time
// Space Complexity: O(1) <-- Only uses variables which take constant space.

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        
        while(low<=high){
            mid = low + (high - low) / 2; // Prevent integer overflow
            // Check if array is already sorted
            if (nums[low] <= nums[mid] && nums[low] <= nums[high] && nums[mid] <= nums[high]){
                return nums[low];
            }

            // Check if middle is the minimum
            if((mid != 0 && nums[mid] < nums[mid - 1]) && (mid!=nums.length - 1 && nums[mid] < nums[mid +1])){
                return nums[mid];
            }

            // Minimum will always be on unsorted side
            // Check if left is sorted, move to right side
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            // If left is unsorted, move to left side
            else {
                high = mid -1;
            }
        }
        return -1;
    }
}
