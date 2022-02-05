# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Binary Search

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        
        while l<r:
            m = (l+r)//2
            if nums[m] < nums[m+1]:
                l = m+1
            else:
                r = m
        return l
