//## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
//approach: Since we need the start and end of the range, we need two separate functions; one to search for the starting point and one ot search for the ending point. Both these functions work similar to the binary search except a small difference where after checking if the element found is the target, it also checks if it's the first element (or the last element for the other function).


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums ==null || nums.length ==0)
        {
            return new int[] {-1,-1};
        }
        int first = searchFirst(nums, target);
        if(first == -1)
        {
            return new int[] {-1,-1};
        }
        int last = searchLast(nums, target, first);
        return new int[] {first,last};
        
    }

    private int searchFirst(int[] nums, int target)
    {
        int low =0;
        int high = nums.length-1;
        int mid;
        while(high>=low)
        {
            mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==0 || nums[mid-1]!=nums[mid])
                {
                    return mid;
                }
                else
                {
                    high = mid-1;
                }
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low =mid+1;
            }
            
        }
        return -1;
    }
    private int searchLast(int[] nums, int target, int low)
    {
        int high = nums.length-1;
        int mid;
        while(high>=low)
        {
            mid = low + (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==nums.length-1 || nums[mid+1]!=nums[mid])
                {
                    return mid;
                }
                else
                {
                    low=mid+1;
                }
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low =mid+1;
            }
            
        }
        return -1;
    }
}