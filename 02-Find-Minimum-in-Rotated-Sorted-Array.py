# Problem 2: Find Minimum in Rotated Sorted Array (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)

# Time Complexity: O(log n) where n is the number of elements in the array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We check if the middle element is less than or equal to the rightmost element to determine which half of the array to search next.
# We keep track of the minimum value found during the search.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return None

        low, high = 0, len(nums)-1
        res = nums[0]

        while low <= high:
            mid = (low+high)//2

            # right sorted
            if nums[mid] <= nums[high]:
                high = mid - 1

            elif nums[mid] >= nums[low]:
                low = mid + 1

            res = min(res, nums[mid])

        return res