/*
 
Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Time Complexity : O(log n)
Space Complexity : O(1)
Did it run on LeetCode : Yes
Any issues encountered : No

 */

 class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lowest = SearchLowestIndex(nums, target);
        if(lowest == -1){
            return new int[]{-1,-1};
        }
        int highest = SearchHighestIndex(nums, target);
        return new int[]{lowest, highest};
    }

    private int SearchLowestIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] != nums[mid - 1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    private int SearchHighestIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}