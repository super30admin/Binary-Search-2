// Time Complexity :O(log n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


class Solution {
    public int findMin(int[] nums) {

     int l = 0;
     int r = nums.length -1;
     if (nums == null || nums.length == 0)
     return -1;
     
     while(l<=r){
        int mid = l + (r-l)/2;
        if(nums[l] <= nums[r]){return nums[l]; } 
        
        if( (mid == 0 || nums[mid] < nums[mid-1]) && 
        (mid == nums.length-1 || nums[mid] < nums[mid+1])){
        return nums[mid];
        } else if (nums[l] <= nums[mid]){
            l = mid + 1;
        }
        else{
            r = mid - 1;
        }
     }
    
    return 2829829;
    }
    
}
