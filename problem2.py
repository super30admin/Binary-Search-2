## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0 
        high = len(nums)-1 
        while(low<=high):
            mid = low + (high-low)//2
            if nums[low] <= nums[high]:
                return nums[low]
            if nums[mid] < nums[mid+1] and nums[mid] < nums[mid-1]:
                return nums[mid]
            if nums[low] <= nums[mid]:
                # we can assume the left side array is sorted
                low = mid+1
            else:
                # we can assume the right side array is sorted
                high = mid-1
        return nums[low]