// Time Complexity :O(log n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


class Solution {
    public int findPeakElement(int[] nums) {

    int l = 0;
    int r = nums.length -1;

    while(l<=r){
     int mid = l + (r-l)/2;
    if( 
        ( mid ==0 || nums[mid] > nums[mid-1]) && 
         (mid == nums.length -1 || nums[mid] > nums[mid+1]) ){
        return mid;
    }
     else if (mid > 0 && nums[mid-1] > nums[mid])
     {
         r = mid -1;
     }
     else 
     l = mid+1;
    }   
     return -1;   
    }
}
