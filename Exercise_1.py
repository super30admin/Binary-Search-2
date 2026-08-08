# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I had to make sure the two binary searches return the outermost matching indexes.
# Approach: I used one binary search to find the first occurrence of the target.
# I used a second binary search to find the last occurrence of the same target.
# If the first search does not find the target, I return [-1, -1] immediately.


class Solution:

    def searchRange(self, nums, target):
        first = self._find_boundary(nums, target, True)

        if first == -1:
            return [-1, -1]

        last = self._find_boundary(nums, target, False)

        return [first, last]

    def _find_boundary(self, nums, target, find_first):
        left = 0
        right = len(nums) - 1
        result = -1

        while left <= right:
            mid = left + (right - left) // 2

            if nums[mid] == target:
                result = mid

                if find_first:
                    right = mid - 1
                else:
                    left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1

        return result
