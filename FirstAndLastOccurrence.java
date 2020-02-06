// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

/*
Approach:
1. Find first based on condition that if target value has lower value to its left, then itself would be first occurrence
2. Find last based on condition that if target value has higher value to its right, then itself would be the last occurrence
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int first = findFirstPosition(nums,target); 
        int last = findLastPosition(nums,target);
        return new int[]{ first, last  };
    }
    
    private int findFirstPosition(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                //value matches target
                if(mid == 0 || nums[mid] > nums[mid-1])  // Implies first occurrence
                    return mid;
                else 
                    high = mid - 1; // first occurrence would always be on left side
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return -1;
    }
    
    private int findLastPosition(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid] < nums[mid + 1])  // Implies last occurrence
                    return mid;
                else 
                    low = mid + 1; // last occurrence would always be on right side
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return -1;
    }
}