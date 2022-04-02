# Binary-Search-2
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

<!-- Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1] -->


public int[] SearchRange(int[] nums, int target) {
     
    if(nums == null || nums.Length == 0)
        return new int[]{-1, -1};
    
    if(target < nums[0] || target >nums[nums.Length - 1])
        return new int[]{-1, -1};
    
    //find first occurence of target using binary search
    int first = binarySearchFirst(nums, target);
    if(first == -1)
        return new int[]{-1,-1};
    
    //find last occurence of target using binary search
    int second = binarySearchLast(nums, target);
        return new int[]{first, second};
    
}

private int binarySearchFirst(int[] nums, int target){
    int low = 0, high = nums.Length -1;
    
    while(low <= high)
    {
        int mid = low + (high - low) / 2;
        
        //we found the target at mid element
        if(nums[mid] == target){
            ///mid is zero or left element is less than current mid, it means we found first occurence of target
            if(mid == 0 || nums[mid-1] < nums[mid]) 
                return mid;
            else //otherwise move to left
                high = mid - 1;
        }
        else //we didnt find the target so left or right by comparing target with mid element
        {
            if(target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
    }
    return -1;
}

private int binarySearchLast(int[] nums, int target){
    int low = 0, high = nums.Length -1;
    
    while(low <= high)
    {
        int mid = low + (high - low) / 2;
        
        if(nums[mid] == target){
        //mid is zero or right element is greater than current mid, it means we found last occurence of target
            if(mid == nums.Length - 1 || nums[mid+1] > nums[mid]) 
                return mid;
            else //go to right side
                low = mid + 1;
        }
        else //we didnt find the target so left or right by comparing target with mid element
        {
            if(target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
    }
    return -1;
}