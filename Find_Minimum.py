# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Your code here along with comments explaining your approach
# Do binary serach and check if mid is greater than right , then minimum is in right elese left.
# One side is always sorted.
import sys
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l, r = 0, len(nums) - 1
        while l < r:
            mid = (l + r) // 2
            #right half
            if nums[mid] > nums[r]:
                l = mid + 1
            #left half
            else:
                r = mid
        return nums[r]

