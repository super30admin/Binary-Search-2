'''
Binary-Search-2

Explain your approach in three sentences only at top of your code

Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:

Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
'''

from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1, -1]

        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        last = self.binarySearchLast(nums, target)
        return [first, last]

    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                if (mid == 0) or (nums[mid] != nums[mid-1]):
                    return mid
                else:
                    #keep moving towards left
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1 

    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                if (mid == len(nums)-1) or (nums[mid] != nums[mid+1]):
                    return mid
                else:
                    #keep moving towards left
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1            

        