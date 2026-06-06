## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2

            # since its a rotated sorted array
            # when our mid element is smaller than the element to its left
            # we have found the min
            # is mid is at 0, then its not rotated and its the smallest
            if mid == 0 or nums[mid] < numd[mid - 1]:
                return nums[mid]

            # one part of the array is always sorted
            # and the lowest element doesn't exist in it

            # left sorted
            if nums[left] <= nums[mid]:
                left = mid + 1
            else:
                right = mid - 1