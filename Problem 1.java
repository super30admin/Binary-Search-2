// Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Time complexity: O(logn)
// Space complexity: O(1)
// Success on leetcode

class Solution {
    
    private static int binarySearchSecond(int nums[], int low, int high, int target) { //time complexity )(logn)
        while (low <= high) {
            int mid = low + (high - low)/2;
             if (nums[mid] == target) {
                 if (mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                     return mid;
                 } else {
                     low = mid + 1;
                 }
             } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            } 
    }
        return -1;
    }
    
    private static int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    // we have to search in the left part
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1,-1};
        int n = nums.length;
        if (nums[0] > target || nums[n-1] < target) return new int[] {-1,-1};
        
        int first = binarySearchFirst(nums,target);
        if (first == -1) return new int[] {-1,-1};
        int last = binarySearchSecond(nums,first,n-1,target);
        return new int[] {first,last};
        
    }
}