"""
time - o(log(n))
space- o(1)
We perform binary search and we eliminate search space based on the condition that the peak element does not exist in the decreasing
part of the search space. If mid+1 is greater than mid then we eliminate the mid-1 and before section, if not eliminate mid+1
"""

from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if mid == len(nums) - 1 or nums[mid] >= nums[mid + 1]:
                hi = mid - 1
            else:
                lo = mid + 1

        return lo
