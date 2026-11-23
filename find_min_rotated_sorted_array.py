# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
# Approach (3 sentences only):
#

from typing import Callable, Dict, Iterator, List, Optional, Tuple


class Solution:

    def findMin(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1
        lowest = float("inf")

        while low <= high:
            mid = (low+high) //2
            lowest = min(lowest, nums[mid])
            if nums[mid] > nums[high]:
                low = mid+1 
            else:
                high = mid -1
        return lowest

if __name__ == "__main__":
    sol = Solution()

    tests = [
        ([3, 4, 5, 1, 2], 1),            # rotated, min in middle
        ([4, 5, 6, 7, 0, 1, 2], 0),      # rotated
        ([11, 13, 15, 17], 11),          # not rotated
        ([2, 1], 1),                     # two elements, rotated
        ([1, 2], 1),                     # two elements, not rotated
        ([1], 1),                        # single element
        ([3, 1, 2], 1),                  # min sits at mid
        ([2, 3, 4, 5, 1], 1),            # min at last index
        ([5, 1, 2, 3, 4], 1),            # min right after first index
        ([1, 4, 17, -7], -7),            # negative values
    ]

    for nums, expected in tests:
        got = sol.findMin(nums)
        status = "PASS" if got == expected else "FAIL"
        print(f"{status}: findMin({nums}) = {got}, expected {expected}")