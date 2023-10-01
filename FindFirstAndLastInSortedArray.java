// time: log(n)
// space: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : had problem accumulating all the return nums[i] conditions

class Solution {
     public int[] searchRange(int[] nums, int target) {
         //if no elements exist
         if(nums==null || nums.length==0) return new int[]{-1, -1};
        
        //get index of left most target
         int indLeft = binarySearchFirstIndex(0, nums.length-1, nums, target);
         //if leftmost target not found
         if(indLeft==-1) return new int[]{-1, -1};
         //get idex of rightmost target
         int indexRight = binarySearchLastIndex(0, nums.length-1, nums, target);

         return new int[]{indLeft, indexRight};
     }


    private int binarySearchFirstIndex(int low, int high, int[] nums, int target){

        while(low<=high){
            //calculating mid index
            int mid = low+(high-low)/2;
            //if target found
            if(nums[mid]==target && (mid==0||nums[mid-1]<target)){
                return mid;
            }
            //if leftmost target on the left half
            else if(target<=nums[mid]){
                high = mid-1;
            }
            //if left most target on the right half
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    private int binarySearchLastIndex(int low, int high, int[] nums, int target){

        while(low<=high){
            //calculating mid index
            int mid = low+(high-low)/2;
            //if target found
            if(nums[mid]==target && (mid==nums.length-1||nums[mid+1]>target)){
                return mid;
            }
            //if rightmost target on the right half
            else if(target>=nums[mid]){
                low = mid+1;
            }
            //if rightmost target on the left half
            else{
                high = mid-1;
            }
        }
        return -1;
    }


}