# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I didn't face any problem while coding this.

# Approach:
# 1. We will use 2 binary search functions to find the first and last occurrence of the target element.
# 2. We will use the first binary search function to find the first occurrence of the target element.
# 3. We will use the second binary search function to find the last occurrence of the target element.
# 4. We will return the first and last occurrence of the target element.
from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, h = 0, len(nums)-1
        # initialize first and last index to -1
        first, last = -1, -1
        while l <= h:
            mid = l + ((h-l)//2)
            # if the mid element is equal to the target element, update the first index and move towards the left to check if there are any more occurrences of the target element
            if nums[mid] == target:
                first = mid
                h = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                h = mid - 1

        l, h = 0, len(nums)-1
        while l <= h:
            mid = l + ((h-l)//2)
            # On the second pass, we will update the last index and move towards the right to check if there are any more occurrences of the target element
            if nums[mid] == target:
                last = mid
                l = mid + 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                h = mid - 1
        # return the first and last index
        return [first, last]