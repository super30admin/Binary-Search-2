#  Time Complexity : O(log n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach: Compare nums[mid] with nums[high]: if it's smaller, search the left half (including mid)
# if it's larger, search the right half
# if they're equal, decrement high to skip the duplicate


class Solution:
    def findMin(self, nums: list[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (
                nums[mid] < nums[mid - 1] or mid == len(nums) - 1
            ):
                return nums[mid]
            elif nums[mid] <= nums[high]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
