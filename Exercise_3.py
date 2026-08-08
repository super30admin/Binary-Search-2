# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I needed to use the slope direction instead of checking every neighbor directly.
# Approach: I compared each middle value with the element next to it.
# If the array is rising at middle, a peak must exist on the right side.
# If it is falling, a peak must exist at middle or on the left side.


class Solution:

    def findPeakElement(self, nums):
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = left + (right - left) // 2

            if nums[mid] < nums[mid + 1]:
                left = mid + 1
            else:
                right = mid

        return left
