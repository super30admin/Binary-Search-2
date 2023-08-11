// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int binarySearchRight(int[] nums,int low, int target){
       int length = nums.length;
       int high = length - 1;
       int mid = 0;
       while(low<=high){
           mid = low + (high-low)/2;
           if(nums[mid]==target){
               if(mid==length-1||nums[mid]<nums[mid+1]){
                   return mid;
               }else{
                   low = mid + 1;
               }
           }else if(nums[mid]>target){
               high = mid - 1;
           }else{
               low = mid + 1;
           }
       }
       return -1;
    }
    public int binarySearchLeft(int[] nums, int target){
        // binary search left 
        int length = nums.length;
       int low = 0;
       int high = length - 1;
       int mid = 0;
       while(low<=high){
           mid = low + (high-low)/2;
           if(nums[mid]==target){
               if(mid==0 || nums[mid]>nums[mid-1]){
                   return mid;
               }else{
                   high = mid - 1;
               }
           }else if(nums[mid]>target){
               high = mid - 1;
           }else{
               low = mid + 1;
           }
       }
       return -1;
    }
    public int[] searchRange(int[] nums, int target) {
       int length = nums.length;
       int low = 0;
       int high = length - 1;
       int mid = 0;
      
       // check edge cases 
       if(nums==null || nums.length==0)
        return new int[] {-1,-1};
       if(target<nums[0] || target>nums[high])
        return new int[] {-1,-1};

       int first = binarySearchLeft(nums,target);
       if(first==-1)
        return new int[] {-1,-1};
       // binary search right
       int last = binarySearchRight(nums,first,target);
       return new int[] {first,last};
    }
}
