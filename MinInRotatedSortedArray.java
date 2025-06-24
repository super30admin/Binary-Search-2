// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Example 1:
// Input: [3,4,5,1,2]
// Output: 1

// Example 2:
// Input: [4,5,6,7,0,1,2]
// Output: 0

class Solution {
    public int findMin(int[] nums) {
        // Base Case
        if(nums.length == 1){
            return nums[0]; // Only one element
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high - low) / 2; // To prevent Integer Overflow

            // Check if mid is the pivot point (i.e. the smallest element)
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            
            // Left half is sorted → min must be in right half
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else { // Right half is sorted → min is in left half
                high = mid - 1;
            }
        }
        return -1; // Should never reach here with valid rotated sorted input

    }
}