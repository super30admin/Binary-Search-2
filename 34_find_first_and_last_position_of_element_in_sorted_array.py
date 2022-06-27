'''
# Problem 34: Find first and last position of the element in sorted array

## Author: Neha Doiphode
## Date:   06-25-2022

## Description:
    Given an array of integers nums sorted in non-decreasing order,
    find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity.

## Examples:
    Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]

    Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1

    Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]

## Approaches:
    * Brute force - Use linear search, which would take O(n) time.
    * Logarithmic - Use binary search,

## Constraints:
        * 0 <= nums.length <= 105
        * -109 <= nums[i] <= 109
        * nums is a non-decreasing array.
        * -109 <= target <= 109

## Time complexity: O(log n), binary search is used throughout.

## Space complexity: O(1), No auxiliary storage is required.

'''

from typing import List

class Solution:
    def binary_search_left(self, nums, target) -> int:
        low = 0
        high = len(nums) - 1
        left_index = -1

        while low <= high:
            mid = low + (high - low) // 2

            # If we find the target, we need to continue searching
            # on the left for the first occurence of the target
            # Before moving to the first occurence, first store the index found
            if target == nums[mid]:
                left_index = mid
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return left_index
                else:
                    high = mid - 1
            elif target < nums[mid]:
                high = mid - 1

            else:
                low = mid + 1
        return left_index


    def binary_search_right(self, nums, target) -> int:
        low = 0
        high = len(nums) - 1
        right_index = -1

        while low <= high:
            mid = low + (high - low) // 2
            if target == nums[mid]:
                right_index = mid
                if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                    return right_index
                else:
                    low = mid + 1

            elif target < nums[mid]:
                high = mid - 1

            else:
                low = mid + 1

        return right_index

    def searchRange(self, nums: List[int], target: int) -> List[int]:

        # Check for edge cases
        if not len(nums):
            return [-1, -1]

        # Check range for the target
        if target < nums[0] and target > nums[len(nums) - 1]:
            return [-1, -1]

        # Initialize first and last occurence
        first = -1
        last = -1

        first = self.binary_search_left(nums, target)

        # If first occurence itself is -1 then we don't have to look for multiple occurences.
        if first == -1:
            return [-1, -1]

        last = self.binary_search_right(nums, target)

        return [first, last]


# Driver code
nums = [5, 7, 7, 8, 8, 10]
target = 8
print(f'Original array: {nums}')
print(f'Target: {target}')

solution = Solution()
l = solution.searchRange(nums, target)
print(f'Element first and last occurence indices are: {l}')
