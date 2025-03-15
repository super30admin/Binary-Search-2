# To get the first and last occurance of the target using Binary Search.
# TC: for both Binary search O(log n) + O(log n) = 2 * log n = O(log n)
# SC: O(1)
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        low, high = 0, n - 1

        def firstPosition(nums, low, high, target):  # to get the first occur.
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:  # if mid is the target
                    if (
                        low == mid or nums[mid - 1] < nums[mid]
                    ):  # to check if its the first pos
                        return mid
                    else:
                        high = mid - 1  # else search in the left part
                elif (
                    nums[mid] > target
                ):  # if an element grater than target look in the left part
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def lastPosition(nums, low, high, target):  # to get the last occurrence
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == high or nums[mid + 1] > nums[mid]:
                        return mid
                    else:
                        low = mid + 1  # Search in the right part
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        # if not nums:
        #     return [-1, -1]

        first = firstPosition(nums, low, high, target)
        last = lastPosition(nums, low, high, target)

        return [first, last]


sol = Solution()
nums = [1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 8, 8, 9]  # Rotated at index 4, minimum = 0
result = sol.searchRange(nums, 5)
print(result)

# def leftBinarySearch(nums:[int], target):
#     index = -1
#     low, high = 0, len(nums) - 1
#     while low <= high:
#         mid = (low+high) // 2
#         if nums[mid] == target:
#             index = mid
#             high = mid - 1 #need to search on the left side
#         elif nums[mid] > target:
#             high = mid - 1
#         else:
#             low = mid + 1
#     return index

# def rightBinarySearch(nums:[int], target):
#     index = -1
#     low, high = 0, len(nums) - 1
#     while low <= high:
#         mid = (low+high) // 2
#         if nums[mid] == target:
#             index = mid
#             low = mid + 1 #need to search on the right side
#         elif nums[mid] > target:
#             high = mid - 1
#         else:
#             low = mid + 1
#     return index

# left = leftBinarySearch(nums, target)
# right = rightBinarySearch(nums, target)
# return [left, right]

# first = -1
# last = -1
# for i in range(len(nums)):
#     if nums[i] == target:
#         if first == -1:
#             first = i
#         last = i
# return [first, last]
