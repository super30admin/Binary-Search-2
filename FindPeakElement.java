// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: Perform binary search and find mid.
//Compare left and right elements of mid and see which one is greater, and go towards the greater value part since we will find
// the peak in that half.

class Solution {
    public int findPeakElement(int[] nums) {
       int n=nums.length;
       int low=0;int high=n-1;
       while(low<=high){
           int mid=low+(high-low)/2;
           
           //check if mid is the starting, or the end element, then return it
           // and if mid is larger than its neighbors
           //mid==- & -1 to handle edge cases
           if((mid==0 || nums[mid] > nums[mid-1]) && (mid==n-1 || nums[mid] > nums[mid+1])){
               return mid;
           } else if(mid>0 && nums[mid] < nums[mid-1]){ 
               // if on the left of mid we have greater element
               // mid>0 to prevent out of bounds, test case [1,2] mid
               high=mid-1;
           } else {
               low=mid+1;
           }
       }
        return -1;
    }
}