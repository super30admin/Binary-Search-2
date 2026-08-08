# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The key detail was comparing the middle value with the right side to locate the rotated part.
# Approach: I used binary search because one side of the rotated array still gives enough ordering information.
# When the middle value is greater than the right value, the minimum must be to the right of middle.
# Otherwise, the minimum is at middle or somewhere to its left, so I keep middle in the search range.


class Solution:

    def findMin(self, nums):
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = left + (right - left) // 2

            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid

        return nums[left]
