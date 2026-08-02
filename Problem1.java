

## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Time complexity : O(logn ) combined
Space Complexity : O(1)

        //lets check for mid and normal binary search if target is less than mid make high as mid -1 and then do binary search again to find target paosition

        // once you find the target  you need to go left to find out where it started, inititally you will check + 1 to the left and increase search space 

        // same goes for right end


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
      int startPos = getStartPos(nums, target, 0, nums.length-1);
      if(startPos == -1 ){
        return new int[]{-1,-1};
      }
      int endPos = getEndPos(nums, target, 0, nums.length-1);

      return new int[]{startPos, endPos};

    }

    private static int getStartPos(int[] nums, int target, int low , int high){

        while(low <= high){
            int mid = low + (high-low)/2;

            if(target == nums[mid]){
                if(mid == low || nums[mid-1] != target){
                    return mid;
                } else {
                    high = mid -1;
                }
            } else if (target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

    private static int getEndPos(int[] nums, int target, int low , int high){

        while(low <= high){
            int mid = low + (high-low)/2;

            if(target == nums[mid]){
                if(mid == high || nums[mid+1] != target){
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }
}