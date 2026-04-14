# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : missed first and last edge case.

# Your code here along with comments explaining your approach
# 2 stacks - 1 for storing actual pushed values,
# 2 - for storing minimum values at each level,
# These 2 stacks must have 1:1 mapping

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        n = len(nums)
        r =  n - 1

        while l <= r:
            mid = l + ( r - l ) // 2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == n-1 or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid + 1] > nums[mid] and mid < n-1:
                l = mid + 1
            else:
                r = mid - 1
        return - 1