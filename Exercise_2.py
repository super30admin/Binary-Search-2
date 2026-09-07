'''
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Time Complexity :
O(n)

Space Complexity :
O(1)

Did this code successfully run on Leetcode :

Yes

Conceptual Approach:

So when an array is rotated, there a couple of insights that we can use:

1. At least one half of the array is sorted (maybe both)
2. In the case that we have an unsorted side, and a sorted side, the minimum value clearly exists in the unsorted half

Such that what we can do, is constantly move towards the unsorted side, and try to find the minimum element. In the case that the array is sorted, simply
return the first element. This should cover all of our cases

We know we've found our element when it is less than the element to the left of it -> this will be the only case that this occurs in a rotated array

Edge Cases:

- The minimum value is the first or the last index of the array
We need to short circuit, such that we do

Binary search only has 2 requirements for application:

1. The search space can be reduced by half
2. The search space can be doubled

I.e. if we can either double or hlave the search space, we can therefore perform binary search

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- The elements are unique

-  nums is rotated between 1 and n times

This array can be rotated such that, it is sorted, i.e.

[0 1 2 3]

- n == nums.length

- 1 <= n <= 5000
We have some edge cases where the array might just be a single element. In which case the minimum is just that element

- -500 <= nums[i] <= 5000

Any problem you faced while coding this:

I got really messed up by the edge case of [2, 1], but then I realized I needed to check both conditions (that the mid is less than its neighbours)
in order to avoid getting caught in this trap
'''
from typing import List


class Solution:
    '''
    [4,5,6,7,0,1,2]
    low = 4
    high = 6
    mid = 5
    '''
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            '''
            I know immediately that once this is sorted, that the minimum is at the first index.

            If I don't do this, I may end up with a range that is fully sorted, which results in me going the wrong direction. I needed to handle this edge case such that when the range is sorted,
            return the first value!
            '''
            is_sorted = nums[low] <= nums[high]

            if is_sorted:
                return nums[low]

            # ALWAYS DO IT THIS WAY TO AVOID INTEGER OVERFLOW
            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                # Left side is sorted, go to the other side!
                low = mid + 1
            else:
                # Right side is sorted - go to the other side
                high = mid - 1
        