//Time Complexity : O(log n) where n is the number of elements in the array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Finding the pivot element.The pivot element is the lowest value.

class Solution {
    public int findMin(int[] nums) {
       if(nums==null || nums.length==0) return -1;
       int low=0;
       int high=nums.length-1;
       while(low<high){
           int mid=low+(high-low)/2;
           if(nums[mid]<nums[high]){
               high=mid;
           }
           else{
               low=mid+1;
           }
             
       }
        return nums[low];
    }
}


// Time Complexity : O(log n) where n is the number of elements in the array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: The code is based on finding a mid that is lesser than the the previous and the next element.(this is the pivot)


class Solution {
    public int findMin(int[] nums) {
       if(nums==null || nums.length==0) return -1;
       int low=0;
       int high=nums.length-1;
       while(low<=high){
           //if(nums[low]<=nums[high]) return nums[low];
           int mid=low+(high-low)/2;
           if((mid==0 ||nums[mid]< nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])  ){
               return nums[mid];
           }
           else if(nums[mid]<nums[high]){
               high=mid-1;
           }
           else
               low=mid+1;
             
       }
        return -1;
    }
}