class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # We need to return any peak in the array, so start search
        # Taking mid point, check if we are at the peak or not
        # If not at the peak, we can be will be on a slope, upwards or downwards. In any case one side of the slope will be upwards.
        # We keep moving on the part of the slope that takes us higer, this gives us a chance that we can find a peak, because if the current is not a peak, then only if we go higher than we can find a peak. If we reach any of the ends and we are still in a slope, then the edge will be the peak.
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1
        return left
