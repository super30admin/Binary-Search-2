// TC - O(logn)
// SC - O(1)
// Ran on Leetcode - Yes
// Mistake made when solving by myself -
// 1. Got confused with the conditions - especially between < and <= comparisons
// 2. Didnt check the already sorted array condition - nums[low] <= nums[high]

class Solution {
    public int findMin(int[] nums) {
        // run binary search and search in unsorted part of array

        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            // check for already sorted array
            if(nums[low] <= nums[high]) return nums[low];

            int mid = low + (high-low)/2;
            // similar condition for checking peak: [large, small, large] where small is the pivot point of the array rotation
            if(
                (mid == 0 || nums[mid] < nums[mid-1]) && 
                (mid == n-1 || nums[mid] < nums[mid+1])
            ){
                return nums[mid];
            }
            // Mistake made - still confused as to why i cant handle the equality in the else case
            else if(nums[low] <= nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return 9999;
    }
}
