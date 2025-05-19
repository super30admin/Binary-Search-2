# Used binary search to find a peak element where nums[i] > nums[i+1] or nums[i-1].
# If mid > mid+1, potential peak is in the left half; else it lies in the right half.
# Continued narrowing the search space until start == end, which will be the peak index.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start, end = 0, len(nums) - 1
        while start < end:
            mid = start + (end - start) // 2
            # If mid is greater than the next element, peak is to the left (including mid)
            if nums[mid] > nums[mid + 1]:
                end = mid
            else:
                # Peak is to the right of mid
                start = mid + 1
        return start
