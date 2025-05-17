"""Approach=> return leftmost element if mid in a sorted array
Go right if mid in left sorted array else right

t.c.=>O(log(n))
s.c.=>O(1)
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        
            
        while l < r:
            mid = l + (r - l)//2
            if nums[l] < nums[r]:
                return nums[l]
            if nums[mid] >= nums[l]:
                l = mid + 1
            else:
                r = mid
        return nums[l]