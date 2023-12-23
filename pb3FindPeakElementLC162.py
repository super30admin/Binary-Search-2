"""
    Approach - we can find any peak elements no restriction
    so we can use binary search and if mid < mid+1 then this 
    mid+1  can be a peak because one of the neighbour and keep searching on that side my moving l to m+1
    similarly search on left my moving to right
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l,r = 0,len(nums)-1
        while l <=r:
            m = (l+r)//2
            if m < len(nums) - 1 and nums[m] < nums[m+1]:
                l = m+1
            elif m > 0 and nums[m] < nums[m-1]:
                r = m-1
            else:
                return m