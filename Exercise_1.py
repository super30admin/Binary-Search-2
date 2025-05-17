# Problem-1:  #34. Find First and Last Position of Element in Sorted Array
# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  #34
# Any problem you faced while coding this : No

# Approach
# Find firstindex and lastIndex using binary search
# First index: search for target, if found, then check if its mid-1 == mid, then search on left side for 1st occurance until mid-1 !=mid
# LastIndex: binary search from 1st idx to n-1. Found? if mid == mid+1 then keep searching on right.


class Solution:
    def firstIndexSearch(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid != 0 and nums[mid] == nums[mid-1]:
                    high = mid -1
                else:
                    return mid
            elif nums[mid] < target:
                low = mid +1
            else:
                high = mid-1
        return -1
    
    def lastIndexSearch(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid != high and nums[mid] == nums[mid+1]:
                    low = mid +1
                else:
                    return mid
            elif nums[mid] < target:
                low = mid +1
            else:
                high = mid-1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) -1
        if nums is None or len(nums) == 0:
            return [-1,-1]
        if nums[low] > target or nums[high] < target:
            return [-1,-1]
        
        firstIndex = self.firstIndexSearch(nums,low,high,target)
        if firstIndex == -1:
            return [-1,-1]
        lastIndex = self.lastIndexSearch(nums,firstIndex,high,target)
    
        return [firstIndex,lastIndex]