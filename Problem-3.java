// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {

        int low = 0;
        int n = nums.length;
        int high = n-1;

        while(low<=high) {
            int mid = low + (high - low)/2;

            if((mid == n-1 || nums[mid]>nums[mid+1]) &&
                (mid == 0 || nums[mid]>nums[mid-1])) {
                    return mid;
            }
            if(mid==n-1 || nums[mid+1] > nums[mid]) {
                //move right
                low = mid+1;
            }
            else if(mid==0 || nums[mid-1] > nums[mid]) {
                //move left
                high = mid-1;
            }
        }
        return -1;
        
    }
}