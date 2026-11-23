# Time Complexity : O(log n) — two binary searches, each halves the range every step
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
# Approach (3 sentences only):
# Run two binary searches over the full array.
# In the first, on a match, stop if mid is index 0 or nums[mid-1] != target; otherwise set high = mid - 1 and keep searching left.
# In the second, stop if mid is the last index or nums[mid+1] != target; otherwise set low = mid + 1.

from typing import Callable, Dict, Iterator, List, Optional, Tuple


class Solution:

    def search_range(self, nums: List[int], target: int) -> List[int]:

        low = 0 
        high = len(nums) - 1
        first_index = -1
        last_index = -1


        while low <= high:
            mid = (low+ high) //2

            if nums[mid] == target:
                if mid - 1 < 0 :
                    first_index = mid
                if mid-1 >= 0 and nums[mid-1] != target:
                    first_index = mid
                    break
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        low = 0 
        high = len(nums) - 1
        # right side search for last index
        while low <= high:
            mid = (low+ high) //2

            if nums[mid] == target:
                if mid + 1 >= len(nums) :
                    last_index = mid
                if mid + 1 < len(nums) and nums[mid+1] != target:
                    last_index = mid
                    break
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1  

        return [first_index, last_index]



if __name__ == "__main__":
    sol = Solution()

    print(sol.search_range([5, 7, 7, 8, 8, 10], 8))  # [3, 4]
    print(sol.search_range([5, 7, 7, 8, 8, 10], 6))  # [-1, -1]
    print(sol.search_range([], 0))                   # [-1, -1]
    print(sol.search_range([1], 1))                  # [0, 0]
    print(sol.search_range([2, 2, 2, 2, 2], 2))      # [0, 4]