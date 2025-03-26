# Time Complexity : O(log2 n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List

class Solution:

    def binarySearchFirst(self, nums, target, low, high) -> int:
        while(low <= high):
            mid = low+(high-low)//2
            if nums[mid] == target:
                if(mid == 0 or nums[mid-1] != target):
                   return mid
                else:
                    high = mid -1
            elif nums[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1  
        return -1 
    def binarySearchLast(self, nums, target, low, high) -> int:
        while(low <= high):
            mid = low+(high-low)//2
            if nums[mid] == target:
                if(mid == len(nums)-1 or nums[mid+1] != target):
                   return mid
                else:
                    low = mid + 1
            elif nums[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
        return -1   

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = self.binarySearchFirst(nums, target, 0, len(nums)-1)
        if first == -1:
            return(-1,-1)

        second = self.binarySearchLast(nums, target, first, len(nums)-1)

        return (first, second)
    