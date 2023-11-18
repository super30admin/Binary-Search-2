# Time Complexity is O(log n). Space complexity is O(1).

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            middle = left + ((right - left) // 2)
            if middle > 0 and nums[middle] < nums[middle - 1]:                 # Edge case check to ensure middle value is greater than 0 and then comparison to determine if left side neighbor is greater.
                right = middle - 1
            elif middle < len(nums) - 1 and nums[middle] < nums[middle + 1]:   # Edge case check to ensure middle value is less than rightmost value and then comparison to determine if right side neighbor is greater.
                left = middle + 1
            else:
                return middle                                                  # Return middle index if that's peak