'''
Time Complexity :
O(log(n))

Space Complexity :
O(1)

Did this code successfully run on Leetcode :

Yes

Conceptual Approach:

So the conceptual approach we discussed in class, which makes sense, is just to conduct two binary searches. One will aim to find the lowest element's index,
and the other will aim to find the highest element's index.

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- 0 <= nums.length <= 10^5

We can have empty arrays

- -10^9 <= nums[i] <= 10^9

Numbers can be negative

- nums is a nn-decreasing array.

This means we will always have the same numbers beside each other if there are multiple occurrences of a number. I.e. we can't have an array like

[1 1 2 2 2 1 1 1]

We can skip numbers, there is no guarantee that the progression of values must represent every number. For example:

[1 3 5 900000 ]

Is a valid array

- -10^9 <= target <= 10^9

There does not exist an edge case in which our target is a value that cannot possibly exist within our array

Any problem you faced while coding this :

No - thankfully this question was quite straight forward

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
'''

from typing import List


class Solution:
    def binary_search_lowest_index(self, arr, target) -> int:
        low = 0
        high = len(arr) - 1
        lowest_index = -1

        while low <= high:
            # We prefer this method in order to prevent an integer overflow - because we can conceptually do (high + low) // 2, but this could cause an overflow
            mid = low + (high - low) // 2

            if arr[mid] == target:
                lowest_index = mid
                high = mid - 1
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return lowest_index

    def binary_search_highest_index(self, arr, target) -> int:
        low = 0
        high = len(arr) - 1
        highest_index = -1

        while low <= high:
            # We prefer this method in order to prevent an integer overflow - because we can conceptually do (high + low) // 2, but this could cause an overflow
            mid = low + (high - low) // 2

            if arr[mid] == target:
                highest_index = mid
                low = mid + 1
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return highest_index

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lowest_index = self.binary_search_lowest_index(nums, target)
        if lowest_index == -1:
            return [-1, -1]
        
        highest_index = self.binary_search_highest_index(nums, target)

        return [lowest_index, highest_index]