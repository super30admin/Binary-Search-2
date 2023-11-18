# Time Complexity is O(log n). Space complexity is O(1).

class Solution:
    def findMin(self, nums: List[int]) -> int:
        result = nums[0]
        left, right = 0, len(nums) - 1

        while left <= right:                        # Check for valid positions to run binary search     
            if nums[left] < nums[right]:            # If left value is less than right, set the minimum. Edge case consideration.
                result = min(result, nums[left])
                break

            middle = left + (right - left) // 2
            result = min(result, nums[middle])      # Save the result as middle to start with.
            if nums[middle] >= nums[left]:          # To determine if middle is in left/right sorted portion.
                left = middle + 1                   # If yes, we have to search right side.
            else:
                right = middle - 1                  # If not, we have to search left side.
        return result