# Binary-Search-2
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


## Problem 3: (https://leetcode.com/problems/find-peak-element/)
<!-- A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity. -->

//we can do in linear search but TC will be O(n)
//to get O(logn), we need ot use binary search, but requirement of binary search is array needs ot be sorted
//we will mid eleemnt and if mid element is not peak, we will move towards larger element O(logn)
public int FindPeakElement(int[] nums) {
    
    if(nums == null || nums.Length == 0)
        return -1;
    
    int  low = 0;
    int high = nums.Length - 1;
    
    while(low <= high)
    {
        int mid = low + (high - low) / 2;
        
        //check for peek
        //if mid is 0 or length of array, we need to check of integer overflow.
        if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.Length-1 || nums[mid] > nums[mid+1]))
            return mid;
        
        //check mid !=0 to avoid integre overflow and then do regular binary search
        if(mid != 0 && nums[mid-1] > nums[mid])
            high = mid-1;
        else
            low = mid+1;
    }
    
    return -1;
}


