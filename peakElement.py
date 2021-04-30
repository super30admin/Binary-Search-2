"""

https://leetcode.com/problems/find-peak-element/submissions/

Observations:
1. Array cannot be sorted
2. adjacent index values will never be same
3. if element has only one neighbor and it is bigger than that neighbor, then it is the peak.
4. Does the peak have to be the first occurrence?
5. The immediate RHS of a peak can never be the peak.

Method 1: Linear search. Check if middle element is greater than both of its neighbors. Special case for first and last
index element. No sliding window needed.
Method 2: Do binary search. Find mid value, check if its greater than both of its neighbors. If not then, move low/high
pointer to the element and side greater than the mid. Repeat till you find peak or low = high. --> O(logn)
**If both neighbors of element are greater than it, move any side as we are not constrained with the maximum peak.**


Runtime Complexity: O(logn)
Space Complexity: O(1)

Yes, it ran on leetcode.
No problems.
"""

from typing import List


class Solution:

    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            # [1], [1,3,2], [2,1]
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid + 1] < nums[mid]):
                return mid
            elif mid > 0 and nums[mid - 1] > nums[mid]:  # If no mid condition, will check for [1,2] and cause exception
                high = mid - 1
            elif mid < len(nums) - 1 and nums[mid + 1] > nums[mid]:  # [1,2], No need to check for mid condition as mid
                # cannot be last element
                low = mid + 1
        return -1

# obj = Solution()
# print(obj.findPeakElement([1,2]))
