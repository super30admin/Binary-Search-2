# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        i = bisect_left(nums, target)
        if (i == len(nums)) or (nums[i] != target):
            return (-1, -1)
        r = (bisect_right(nums, target) - 1)
        return (i, r)