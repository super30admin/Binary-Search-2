// (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class Solution {
    public int first(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;
                else high = mid - 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int second(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > target) return mid;
                else low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int[] searchRange(int[] nums, int target) {
         int left = first(nums, 0, nums.length - 1, target);
        int right = second(nums, 0, nums.length - 1, target);
        return new int[] {left,right};
    }
}

class Problem1 {

  public static void main(String[] args) {
    int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 16 };
    Solution sol = new Solution();
    System.out.println(sol.searchRange(array, 15));
  }
}
