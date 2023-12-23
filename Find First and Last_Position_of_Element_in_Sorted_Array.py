#time complexity: O(log n)
#space complexity: O(1)
from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0: #base case
            return [-1, -1]
        if target < nums[0] or target > nums[-1]:  # from 0th indext to length - 1 traversing
            return [-1, -1]
        
        first = self.binarySearchFirstOccurrence(nums, target)
        if first == -1:
            return [-1, -1]
        
        last = self.binarySearchLastOccurrence(nums, target)
        return [first, last]

    def binarySearchFirstOccurrence(self, nums, target):
        low = 0
        high = len(nums) - 1  
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                # check if it is the first occurrence
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid
                else: #if not less
                    high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1

    def binarySearchLastOccurrence(self, nums, target):
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                # check if it is the last occurrence
                if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
