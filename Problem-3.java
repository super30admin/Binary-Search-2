// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    // Perform binary search and check if the current mid is the peak element
    // If the left element of peak is greater than mid then move to left half otherwise move to right half
    // Repeat till peak is found
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = low + (high-low) / 2;
            // check if it is peak element
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1]))
                return mid;
            // if left element of mid is greater than itself
            else if(nums[mid+1] > nums[mid]) {
                low = mid + 1;
            }
            // right element of mid is greater
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}