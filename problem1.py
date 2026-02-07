## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

class Solution:

    def leftBinary(self,nums,low,high,target):
        while(low<=high):
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == low or nums[mid-1] != nums[mid]:
                    return mid
                else:
                    high=mid-1
            elif nums[mid] > target:
                high = mid-1 
            else:
                low = mid+1
        return -1

    def rightBinary(self,nums,low,high,target):
        while(low<=high):
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == high or nums[mid+1] != nums[mid]:
                    return mid
                else:
                    low = mid+1
            elif nums[mid] > target:
                high = mid-1
            else:
                low = mid+1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0 
        high = len(nums)-1 
        # find the low index
        return [self.leftBinary(nums,low,high,target),self.rightBinary(nums,low,high,target)]