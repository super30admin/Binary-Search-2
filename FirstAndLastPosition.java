// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Base Case
        if (nums == null || nums.length == 0){
            return new int[] {-1, -1};
        }
        int first = BinarySearchFirst(nums, target);
        if(first == -1){ // target not found at all
            return new int[] {-1, -1};
        }
        int last = BinarySearchLast(nums, target);
        return new int[] {first, last};
    }

    // Finds first (leftmost) occurrence of target
    private int BinarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2; // To prevent Integer Overflow
            if (nums[mid] == target){
                if (mid == 0 || nums[mid - 1] != nums[mid]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if (target < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1; // not found
    }

    // Finds last (rightmost) occurrence of target
    private int BinarySearchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2; // To prevent Integer Overflow
            if (nums[mid] == target){
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if (target < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1; // not found
    }

}