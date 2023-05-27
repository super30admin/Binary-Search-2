from ast import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums)-1

        while l <= h:
            m = l + (h-l)//2

            if m>0 and nums[m]<nums[m-1]:
                h = m - 1
            elif m<len(nums)-1 and nums[m]<nums[m+1]:
                l = m + 1
            else:
                return m
