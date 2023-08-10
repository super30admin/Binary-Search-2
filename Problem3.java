// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length-1;
        int mid  = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(
                (mid==0 || nums[mid]>nums[mid-1]) 
                && 
                (mid==length-1 || nums[mid]>nums[mid+1])
            ){
                return mid;
            }else if(mid>0 && nums[mid-1]>nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
