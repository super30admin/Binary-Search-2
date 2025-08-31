from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def first():
            first = -1
            l = 0 
            r = len(nums) - 1 
            while l <= r: 
                mid = (l + r) // 2 
                if nums[mid] == target:
                    first = mid
                    r = mid - 1 
                elif nums[mid] > target:
                    r = mid - 1 
                else: 
                    l = mid + 1 
            return first 
        
        def second():
            second = -1 
            l = 0 
            r = len(nums) - 1 
            while l <= r: 
                mid = (l + r) // 2 
                if nums[mid] == target:
                    second = mid
                    l = mid + 1  # keep looking right
                elif nums[mid] < target:
                    l = mid + 1 
                else: 
                    r = mid - 1 
            return second 
        
        return [first(), second()]
