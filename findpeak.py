# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach:
# Use binary search to find a peak element. A peak element is greater than its neighbors.
# Narrow the search space until a peak is found.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        while l <= h:
            m = (l + h) // 2
            if (m == 0 or nums[m - 1] < nums[m])  and (m == len(nums) - 1 or nums[m] > nums[m + 1]):
                return m 
            elif nums[m + 1] > nums[m]:
                l = m + 1
            else:
                h = m - 1
        
        return -1
