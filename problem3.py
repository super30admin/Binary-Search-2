# Time Complexity - O(log n)
# Space Complexity - O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid  # Peak is on the left side including mid
            else:
                left = mid + 1  # Peak is on the right side excluding mid

        return left  # or right, both point to the peak
