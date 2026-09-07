'''
https://leetcode.com/problems/find-peak-element/

Time Complexity :

O(log(n))

Space Complexity :
O(1)

Did this code successfully run on Leetcode:

Yes

Conceptual Approach:

So this question can be rephrased as an extremely simple calculus question! It is asking us to find a local maximum (which is guaranteed to exist).
All that means is we can follow the derivative whenever it points in a positive direciton, and just go towards that (always head towards higher ground).

So this is just a simple binary search whereby I always head towards the higher value, and I stop once I've reached a peak. I've reached a peak
when it is greater than both of it's neighbours

Edge Cases:

- Boundary values should be considered greater than their neighbours that would theoretically be outside of the array (first and last indices only
need to be compared to a single neighbour)

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- Your algorithm must run in O(log n) time

- 1 <= nums.length <= 1000
- 2^31 <= nums[i] <= 2^31 - 1
- nums[i] != nums[i + 1] for all valid i.

This is an extremely important constraint! It tells us that neighbouring values cannot be equal to each other. This by definition implies that there
is always at least one peak per solution!

- an element is always considered to be strictly greater than a neighbor that is outside the array.

This means that boundary values (first or last index) are considered to be greater than at least 1 of their neighbours. Therefore they only need to
be greater than their 1 internal neighbour


Any problem you faced while coding this:

Yes, and edge case that I did not account for initially was the fact that we could be on a boundary index (first or last), and if it isn't the peak,
we need to keep iterating. My original branching logic was like this:

if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
    return mid
elif nums[mid - 1] > nums[mid]:
    # Larger value is to the left
    high = mid - 1
else:
    low = mid + 1

Which failed the case
nums = [1 2]

This was because the first mid point selected is at index 0 - and when trying to compared nums[mid - 1] > nums[mid], since mid -1 (-1) was not a valid
index, this would raise an error.

To fix this statement

elif nums[mid - 1] > nums[mid]:
    # Larger value is to the left
    high = mid - 1

I simply need to account for this by checking if that mid isn't 0 and otherwise short circuiting

elif mid != 0 and nums[mid - 1] > nums[mid]:
    # Larger value is to the left
    high = mid - 1


'''

from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            # We always do this to avoid an integer overflow even though we could theoretically do (high + low) // 2
            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid != 0 and nums[mid - 1] > nums[mid]:
                # Larger value is to the left
                high = mid - 1
            else:
                low = mid + 1