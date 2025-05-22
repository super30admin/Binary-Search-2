# Use two modified binary searches: one to find the first position, one for the last.
# On finding target, search further left (for first) or right (for last).
# If target not found, return [-1, -1].
from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # Helper function to find the first occurrence of target using binary search
        def findFirst(nums, target):
            low, high = 0, len(nums) - 1
            result = -1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    result = mid  # Potential first occurrence found
                    high = mid - 1  # Continue searching to the left for earlier occurrence
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return result
        
        # Helper function to find the last occurrence of target using binary search
        def findLast(nums, target):
            low, high = 0, len(nums) - 1
            result = -1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    result = mid  # Potential last occurrence found
                    low = mid + 1  # Continue searching to the right for later occurrence
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return result
        
        # Call helper functions and return result
        first = findFirst(nums, target)
        last = findLast(nums, target)
        return [first, last]
