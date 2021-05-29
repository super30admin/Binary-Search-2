class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1
        if high == 0 or nums[0] < nums[high]: return nums[0]
        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] > nums[low]:
                low = mid
            else:
                high = mid
        return nums[low + 1]

