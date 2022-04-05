# Binary-Search-2
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

<!-- Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0 -->

public int FindMin(int[] nums) {
    
    
    int low = 0;
    int high = nums.Length - 1;
    
    while(low <= high)
    {
        //if arrayis sorted in ascending order from low to high, return lowest element      
        if(nums[low] <= nums[high])
        return nums[low];
        
        
        int mid = low + (high - low) / 2;
        
        if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.Length - 1 || nums[mid] < nums[mid+1]))
            return nums[mid];
                
        //it means left part of array is sorted, go to right part of arraqy
        if(nums[low] <= nums[mid])
            low = mid + 1;
        else
            high = mid - 1;
        
    }
    return -1;
}
