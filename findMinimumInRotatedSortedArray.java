// Time Complexity: O(log N)
// Space Complexity: O(1)

// Did this run on leetcode: Yes
// Any Issues you faced while coding this: No

// Explaination

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            // Check if the array is already sorted if yes then just return first number
            if(nums[low] <= nums[high]) return nums[low];
            
            // To prevent integer overflow
            int mid = low + (high - low) / 2;
            
            // How do we determine if the number is min
            // Check if the neighbor values are less than current element
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } 
            // Minimum number in rotated sorted array will always be in un-sorted part
            // So check in this case if left side is sorted or right side is sorted
            else if(nums[low] <= nums[mid]) { // Left Sorted 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}