# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

# Time Complexity : O(log(N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach in three sentences only
# Approach : We can divide this into two parts, by finding the left most occurrence and right most occurrence of the
# given target. Left Most occurrence can be found by moving left until our mid is target and mid - 1 is not target
# Right Most occurrence can be found by moving right until our mid is target and mid + 1 is greater than target.

from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.findFirstOccurance(nums, target), self.findLastOccurance(nums, target)]

    def findFirstOccurance(self, nums, target):
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                # Now, we found the target we have to check if it is the starting point, by comparing it with
                # previous element
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                high = mid - 1

            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

    def findLastOccurance(self, nums, target):
        low, high = 0, len(nums) - 1
        size = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                # Now, we found the target we have to check if it is the last point, by comparing it with next element
                if mid == size or nums[mid] < nums[mid + 1]:
                    return mid
                low = mid + 1

            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1