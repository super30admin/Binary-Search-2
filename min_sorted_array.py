from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        low = 0
        high = len(nums) - 1
        if nums[low] <= nums[high]:  # Perfectly Sorted Array
            return nums[low]
        while low <= high:
            mid = low + ((high - low) // 2)
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] < nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
