// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int findPeakElement(int[] nums) {
        int high = nums.length - 1;
        int low =0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid >= nums.length - 1 || nums[mid]> nums[mid+1])){
                return mid;
            }
            if(mid > 0 && nums[mid-1] > nums[mid]){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
}