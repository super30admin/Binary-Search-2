"""
Approach=> multiple peaks present and ends are always -inf so go right if on a positive slope or
left on negative slope
t.c.=> O(log(n))
s.c.=> O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            mid = l + (r - l)//2
            if nums[mid] < nums[mid + 1]:
                l = mid + 1
            else:
                r = mid
        return r
