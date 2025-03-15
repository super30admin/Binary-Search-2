# Binary Search to find the minimum element in sorted roated array using property minimum value always lies in unsorted part with
# conditions if array is sorted or mid is the minimum
# TC: O(log n) using BS in one half to get the element
# SC: O(1) Constant Space
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[low] <= nums[high]:  # if array is sorted
                return nums[low]
            # Check if mid is the minimum element
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (
                mid == n - 1 or nums[mid] < nums[mid + 1]
            ):
                return nums[mid]

            if nums[low] <= nums[mid]:  # minimum value always in unsorted range
                low = (
                    mid + 1
                )  # If left half is sorted, the minimum must be in the right half
            else:
                high = mid - 1  # Otherwise, the minimum is in the left half
        return -1  # This line will never be reached in a valid rotated sorted array


sol = Solution()
nums = [4, 5, 6, 7, 0, 1, 2]  # Rotated at index 4, minimum = 0
result = sol.findMin(nums)
print(result)

# n = len(nums)
# low = 0
# high = n-1
# minimum_element = float("inf")
# while low <= high:
#     mid = (low+high) // 2
#     if nums[low] <= nums[high]:
#         minimum_element = min(minimum_element, nums[low])
#         break
#     if nums[low] <= nums[mid]: # check if left side of array is sorted
#         minimum_element = min(minimum_element, nums[low]) #to find minimum element
#         low = mid + 1
#     else: # check if right side of array is sorted
#         minimum_element = min(minimum_element, nums[mid])
#         high = mid - 1
# return minimum_element

# minimum = float("inf")
# for i in range(len(nums)):
#     minimum = min(minimum, nums[i])
# return minimum
