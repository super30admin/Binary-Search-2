# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use binary search on the rotated sorted array and 
# Track the minimum value while narrowing the search space.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        res = float('inf')

        while l <= h:
            m = (l + h) // 2
            res = min(res, nums[m])

            if nums[m] > nums[h]:
                l = m + 1
            else:
                h = m - 1

        return res
