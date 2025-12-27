"""
time - o(log(n))
space - o(1)
We perform binary search to eliminate search space that is sorted because a sorted section of a rotated array does not contain the pivot
element (except with low and hi are in sorted order). there are do stopping conditions, we find mid and if mid is smaller than
left and right elements we return mid. If low and hi are sorted then it means low is the pivot and we return.
"""

from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            if nums[lo] <= nums[hi]:
                return nums[lo]
            mid = lo + (hi - lo) // 2
            if (
                0 < mid < len(nums) - 1
                and nums[mid + 1] > nums[mid]
                and nums[mid - 1] > nums[mid]
            ):
                return nums[mid]
            if nums[lo] <= nums[mid]:
                lo = mid + 1
            else:
                hi = mid
