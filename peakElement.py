# finding the peak element in an array: Using Bonary search
# TC: O(log n) Binary Search
# SC: O(1) constant space
from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low) // 2  # get the mid

            # to check if mid is the peak with conditions for first and last element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (
                mid == n - 1 or nums[mid] > nums[mid + 1]
            ):
                return mid
            elif (
                mid == n - 1 or nums[mid + 1] > nums[mid]
            ):  # move towards higher element to get the peak element , if not last element(doesnt have right element)
                low = mid + 1
            else:
                high = mid - 1
        return -1  # This line will never be reached


sol = Solution()
nums = [4, 5, 6, 7, 0, 1, 2]  # Rotated at index 4, minimum = 0
result = sol.findPeakElement(nums)
print(result)
# if len(nums) == 1:

#     return 0
# if nums[0] > nums[1]:
#     return 0
# elif nums[-1] > nums[-2]:
#     return len(nums) - 1
# low = 1
# high = len(nums) - 2
# while low <= high:
#     mid = (low + high) // 2
#     if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
#         return mid
#     if nums[mid] > nums[mid + 1]:
#         high = mid - 1
#     else:
#         low = mid + 1
