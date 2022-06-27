'''
153. Find Minimum in Rotated Sorted Array

Author: Neha Doiphode
Date: 06-25-2022

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.



Constraints:

    n == nums.length
    1 <= n <= 5000
    -5000 <= nums[i] <= 5000
    All the integers of nums are unique.
    nums is sorted and rotated between 1 and n times.


Time complexity : O(log n)
Space complexity: O(1)

'''
from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        min_element = 5000
        # Check which half is sorted

        while low <= high:
            mid = low + (high - low) // 2
            # sorted part of the array
            if nums[mid] < min_element:
                min_element = nums[mid]

            if nums[low] < nums[mid]:
                if nums[low] < min_element:
                    min_element = nums[low]
                low = mid + 1

            else:
                if nums[high] < min_element:
                    min_element = nums[high]
                high = mid - 1

        return min_element

    def findMin_1(self, nums: List[int]) -> int:
        if len(nums) == 1 or nums[0] <= nums[len(nums) - 1]:
            return nums[0]

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if ((nums[mid] < nums[mid - 1]) and (nums[mid] < nums[mid + 1])):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return 5000



# Driver code
l = [4, 5, 0, 1, 2, 3]
solution = Solution()
print(f'Original list: {l}')
print(f'Minimum element - approach 1: {solution.findMin(l)}')
print(f'Minimum element - approach 2: {solution.findMin_1(l)}')
