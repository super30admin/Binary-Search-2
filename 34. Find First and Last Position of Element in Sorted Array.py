# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
from typing import List

class Solution:
    
    def searchFirst(self, nums: List[int], low: int, high: int, target: int) -> int:
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchLast(self, nums: List[int], low: int, high: int, target: int) -> int:
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] != nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        if nums[0] > target or nums[-1] < target:
            return [-1, -1]
        first = self.searchFirst(nums, 0, len(nums) - 1, target)
        if first == -1:
            return [-1, -1]
        last = self.searchLast(nums, first, len(nums) - 1, target)
        return [first, last]
