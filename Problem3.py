# https://leetcode.com/problems/find-peak-element/

# This problem is about finding the peak element in an array. The array will be unsorted or sorted. No two adjacent elements will be the same, but there can be repetitive elements. Goal is to find the index of any peak element. A peak element will be greater then it's neighbor elements.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        if len(nums) == 1:
            return 0

        while low <= high:
            mid = (low + high) // 2
            if mid == high or nums[mid] < nums[mid + 1]:
                low = mid + 1
            elif mid == low or nums[mid] < nums[mid - 1]:
                high = mid - 1
            if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid
        
        return -1