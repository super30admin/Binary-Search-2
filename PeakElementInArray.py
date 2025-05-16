"""
Time Complexity: O(log n)
Space Complexity : O(1)  

Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

# Uses binary search to find a peak element where the value is greater than its neighbors.
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[mid + 1]:
                r = mid
            else:
                l = mid + 1
        return l