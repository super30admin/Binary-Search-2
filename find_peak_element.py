# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
#
# Approach (3 sentences only):
#

from typing import Callable, Dict, Iterator, List, Optional, Tuple


class Solution:

    def findPeakElement(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1

        while low < high:
            mid = (low+high)//2

            if nums[mid] > nums[mid+1]:
                high = mid
            else:
                low = mid + 1

        return low


if __name__ == "__main__":
    sol = Solution()

    def is_peak(nums, i):
        left = nums[i - 1] if i > 0 else float("-inf")
        right = nums[i + 1] if i < len(nums) - 1 else float("-inf")
        return nums[i] > left and nums[i] > right

    tests = [
        [1, 2, 3, 1],            # peak in middle -> 2
        [1, 2, 1, 3, 5, 6, 4],   # two peaks -> 1 or 5
        [1, 2, 3, 4],            # rising -> last index
        [4, 3, 2, 1],            # falling -> index 0
        [1],                     # single element -> 0
        [2, 1],                  # two elements -> 0
        [1, 2],                  # two elements -> 1
        [1, 3, 2],               # peak at mid -> 1
    ]

    for nums in tests:
        i = sol.findPeakElement(nums)
        status = "PASS" if is_peak(nums, i) else "FAIL"
        print(f"{status}: findPeakElement({nums}) = {i}")

