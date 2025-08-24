"""
TC: O(log(N)) {since we perform binary search to first find the element, and then do two binary searches in each half to search for
                the lowest and the highest. Since constants dont matter in time complexities, we get O(log(N)) t.c.}
SC: O(1)        {we dont use any extra spaces}

The problem succesfully ran on LeetCode
"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        if len(nums) == 1:
            return [0,0] if nums[0] == target else [-1,-1]
        
        def expand(idx):
            # for searching the lowest occurence
            low = 0
            high = idx

            lowest = high

            while low <= high:
                mid = low + (high - low)//2
                if nums[mid] == target:
                    high = mid - 1
                    lowest = mid
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    break
            
            # searching for the highest
            low = idx
            high = len(nums)-1
            highest = low

            while low <= high:
                mid = low + (high - low)//2
                if target == nums[mid]:
                    low = mid + 1
                    highest = mid
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    break
            return [lowest, highest]





        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low)//2

            if target == nums[mid]:
                start, end = expand(mid)
                return [start, end]
            
            if nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        
        return [-1, -1]
       
       