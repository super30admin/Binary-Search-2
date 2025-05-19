# Used binary search to find the minimum element in a rotated sorted array.
# Checked if the current mid or its next/previous neighbor is the point of rotation (i.e., the minimum).
# Based on comparisons, adjusted the search space to narrow down the region where the rotation (and hence minimum) occurs.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2

            # Check if mid+1 is the smallest element
            if mid < len(nums) - 1 and nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            # Check if mid itself is the smallest element
            if mid > 0 and nums[mid] < nums[mid - 1]:
                return nums[mid]

            # Decide the search direction
            if nums[mid] < nums[left]:
                right = mid - 1
            else:
                if nums[right] < nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1

        return nums[mid]