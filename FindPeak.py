# keep climbing up (look for bigger), you'll reach the peak
# Time Complexity: O(log n)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2 

            # Check if mid is a peak:
            # 1. Either it's the first element or greater than the left neighbor
            # 2. Either it's the last element or greater than the right neighbor
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid  # Found a peak

            # If left neighbor is greater, the peak must be on the left side
            elif mid > 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1

            # Otherwise, the peak must be on the right side
            else:
                low = mid + 1

        return -1  # Should never be reached if array has at least one element
