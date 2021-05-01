"""
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Pivot (index where array is rotated) is the minimum element. Pivot will be in the unsorted sub-array.

Method 1: Linear Search and keep track of min.
Method 2: Rotated sorted array. Use binary search.
1. Find mid.
2. If mid value == pivot, i.e. mid value < mid value - 1 and mid value > mid value + 1, return mid. Otherwise, reduce
the search sub-space.
3. At the mid value, check which sub-array is sorted. Minimum value would be at the unsorted sub-array. Reduce the search
sub-space to the unsorted sub-array.
4. Repeat steps 1-3 while low <= high.
O(logn)

Edge cases:
1. Array is in descending order
2. Both arrays are sorted.


# Runtime Compelexity: O(logn)
# Space Compelexity: O(1)

Yes, it worked on leetcode
I did not have any problems
"""

from typing import List


class Solution:

    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[low] < nums[high]: # entire array is sorted, so directly return first element
                return nums[low]
            # check if mid is pivot
            if mid == 0 or nums[mid] < nums[mid - 1] and mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                return nums[mid]
            elif nums[mid] >= nums[low]:  # check for left sorted array so select right unsorted sub-array. Condition
                # will fail for both sorted sub-arrays. Eg; [4 5 6 7 0 1 2], sub-array [0 1 2]; [2,1]
                # low and middle can coincide but low and high cannot coincide
                low = mid + 1
            else:
                high = mid - 1 # if condition applied here instead of above, condition will not fail for both sorted
                # sub-arrays.
