class Solution:
    def findMin(self, nums):
        n = len(nums)
        low, high = 0, n - 1

        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] <= nums[high]:  # right sorted range
                high = mid
            else:
                low = mid + 1

        return nums[low]
