# Time Complexity : 2*O(logn) = O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We first perform a binary search to find left boundary, then one to find the right boundary.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        firstIdx = self.binLeft(nums, 0, len(nums)-1, target)
        if firstIdx == -1:
            return [-1, -1]
        lastIdx = self.binRight(nums, firstIdx, len(nums)-1, target)
        return [firstIdx, lastIdx]


    def binLeft(self, nums, l, h, target):
        while l <= h:
            m = l + (h-l)//2
            if nums[m] == target and (m == 0 or nums[m-1] < nums[m]):
                return m
            elif nums[m] >= target:
                h = m - 1
            else:
                l = m + 1
        return -1

    def binRight(self, nums, l, h, target):
        while l <= h:
            m = l + (h-l)//2
            if nums[m] == target and (m == len(nums)-1 or nums[m] < nums[m+1]):
                return m
            elif nums[m] <= target:
                l = m + 1
            else:
                h = m - 1
        return -1

