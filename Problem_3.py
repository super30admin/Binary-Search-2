# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        r = (len(nums) - 1)
        i = 0
        while i < r:
            x = ((i + r) // 2)
            if nums[x] >= nums[x + 1]:
                r = x
            else:
                i = (x + 1)
        return i