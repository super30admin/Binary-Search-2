"""
Time complexity - o(logn)
space complexity - o(1)
We find the first occurence doing binary search, we modify the exit condition, instead of return the index as soon as we find the target
like in normal binary search we enter into a sub condition where we check if the element to the left of the found target index is lesser
than target, if yes we found the first occurence, if no, there are more to the left so we reduce search space by making hi as mid-1
if we don't find the target in the initial search, return -1 and return [-1,-1] in the main function
if we do find the first occurence, we need to find the last occurence and we do that by again doing another binary search, this is done
by making first occurence of target as lo and end of list as hi. We once again check if mid==target and if it is, we enter into a sub-condition
if the number to the right of mid is greater than target then we return mid if not we move lo to mid+1
"""

from typing import List


class Solution:
    def search_start_index(self, nums, target):
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] < target:
                    return mid
                else:
                    hi = mid - 1
            elif nums[mid] > target:
                hi = mid - 1
            else:
                lo = mid + 1
        return -1

    def search_last_index(self, nums, target, lo, hi):
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] > target:
                    return mid
                else:
                    lo = mid + 1
            elif nums[mid] > target:
                hi = mid - 1
            else:
                lo = mid + 1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start_index = self.search_start_index(nums, target)
        if start_index == -1:
            return [-1, -1]
        last_index = self.search_last_index(nums, target, start_index, len(nums) - 1)
        return [start_index, last_index]
