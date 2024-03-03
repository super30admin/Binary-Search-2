# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

***************************************************************************

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int[] searchRange(int[] nums, int target) {
                int min = findFirst(nums, target);
        int max = findLast(nums, target);
        return new int[]{min, max};
    }

    public int findFirst(int nums[], int target) {
        int min=-1;
        int left=0,right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                min=mid;
            if(target<=nums[mid])
                right=mid-1;
            else
                left=mid+1;
        }
        return min; 
    }

    public int findLast(int nums[], int target) {
        int max=-1;
        int left=0,right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                max=mid;
            if(target>=nums[mid])
                left=mid+1;
            else
                right=mid-1;
        }
        return max; 
    }
}

****************************************************************************
## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0
****************************************************************************

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<=right)
        {
            if(nums[left]<=nums[right])
            {
                return nums[left];
            }
            int mid=left+(right-left)/2;
            if(mid!=0 && nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            else if(nums[left]<=nums[mid])
            {
                left=mid+1;

            }
            else
            {
                right=mid-1;
            }
        }
        return 0;
        
    }
}

****************************************************************************
## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

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

Your solution should be in logarithmic complexity.

****************************************************************************

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(left==right)
            {
                return mid;
            }
            else if(nums[mid]<nums[mid+1])
                left=mid+1;
            else if(nums[mid]>nums[mid+1])
                right=mid;
        }
        return 0;
        
    }
}

****************************************************************************


