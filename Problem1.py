"""
(https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].
"""
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def findFirst(nums, target):
            low, high = 0, len(nums) - 1
            first = -1
            while low <= high:
                mid = (low + high) // 2
                if nums[mid] == target:
                    first = mid
                    high = mid - 1  # keep going left
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return first

        def findLast(nums, target):
            low, high = 0, len(nums) - 1
            last = -1
            while low <= high:
                mid = (low + high) // 2
                if nums[mid] == target:
                    last = mid
                    low = mid + 1  # keep going right
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return last

        first = findFirst(nums, target)
        last = findLast(nums, target)
        return [first, last]