// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    // Perform binary search to find the minimum element in the array
    // If array is already sorted return the first element
    // Otherwise the minimum element will always be on the unsorted half 
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high) {
            // check if complete array is sorted
            if(nums[low] <= nums[high])
                return nums[low];

            int mid = low + (high - low) / 2;
            // if the mid element is the minimum element
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            // if the left half is sorted reject left half
            else if(nums[mid] >= nums[low]) {
                low = mid + 1;
            }
            // Reject sorted right half
            else {
                high = mid - 1;
            }
        }
        return 0;
    }
}