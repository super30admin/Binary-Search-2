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

class Solution:
    def binary_search_first(self, nums, left, right, target):
        while left <= right:
            mid = (right - left)//2 + left
            if nums[mid] is target:
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    right = mid - 1
            
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1
    
    def binary_search_second(self, nums, left, right, target):
        while left <= right:
            mid = (right - left)//2 + left
            if nums[mid] is target:
                if mid == (len(nums)-1) or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    left = mid + 1
            
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums) - 1
        if len(nums) is 0:
            return [-1, -1]
        if target < nums[0] or target > nums[n]:
            return [-1,-1]

        first_index = self.binary_search_first(nums, 0, n, target)
        if first_index is -1:
            return [-1,-1]
        second_index = self.binary_search_second(nums, first_index, n, target)
        return [first_index, second_index]


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

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        if len(nums) == 1: 
            return nums[0]
        while left <= right:
            mid = (right-left)//2 + left

            if nums[mid] < nums[mid-1]:
                return nums[mid]
            elif nums[mid] <= nums[right]:
                right = mid - 1
            elif nums[mid] > nums[right]:
                left = mid + 1
        

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


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        if len(nums) == 1:
            return 0

        while left <=right:
            mid = (left+right)//2

            # left
            if mid == 0 and nums[mid] > nums [mid+1]:
                return mid
            # right
            elif mid == len(nums) - 1 and nums[mid] > nums [mid-1]:
                return mid
            # mid 
            elif 0 < mid < len(nums) - 1 and nums[mid-1] < nums[mid] and nums[mid+1] < nums[mid]:
                return mid  

            elif mid > 0 and nums[mid] < nums[mid-1]:
                right = mid - 1
            else:
                left = mid + 1

