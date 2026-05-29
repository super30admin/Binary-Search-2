class Solution:
    def findPeakElement(self, nums):
        n = len(nums)
        low, high = 0, n - 1

        while low < high:
            mid = low + (high - low) // 2
            if nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                high = mid

        return low
