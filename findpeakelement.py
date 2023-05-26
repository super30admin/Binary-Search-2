#Time Complexity=O(logn)
#Space Complexity =O(1)
#// Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] < nums[mid + 1]:
                l =  mid + 1
            else:
                r = mid 
        return l