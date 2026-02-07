# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : It uses binary search to locate the smallest element in a rotated sorted array
# by checking neighbors. At each step, it discards the sorted half
# since the minimum must lie in the unsorted side.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            if nums[low] <= nums[high]:  # only one element in range
                return nums[low]

            mid = low + (high - low) // 2

            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:  # left sorted
                low = mid + 1  # min always in unsorted side
            else:
                high = mid - 1