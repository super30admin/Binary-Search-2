/*
 * Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(logN)
* 
* Space Complexity: O(1)
Approach:
*
 1. Apply binary search to array to find first occurrence
* 
*2. Again apply binary search in the range of first occurence to high --  find last occurrence

 */
class Solution {

    private int BinarySearchLeft(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid] > nums[mid-1] )  //checking first occurnace
                     return mid;
                else high = mid - 1;  // keep moving left
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return -1;
    }
 
    private int BinarySearchRight(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                if(mid == nums.length -1  || nums[mid] < nums[mid+1] )  //checking first occurnace
                     return mid;
                else     
                     low = mid + 1;  // kkep moving Right
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return -1;
    }
 
 
     public int[] searchRange(int[] nums, int target) {
         //null
         //
         if(nums == null || nums.length == 0) return new int []{-1,-1};
         int n = nums.length;
         int left = BinarySearchLeft(nums,0,n-1,target);
         if(left == -1) return new int []{-1,-1};
         int right = BinarySearchRight(nums,left,n-1,target);
         return new int []{left,right};
     }
 }