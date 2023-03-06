from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        
        low, high = 0, len(nums) - 1
        n = len(nums)
        while (low <=high):
            mid = low + (high - low) / 2
            if ((mid == 0 or nums[mid]> nums[mid - 1])and (mid == n-1 or nums[mid + 1])):
                return nums[mid]
            elif(nums[mid - 1] > nums[mid]):
                high = mid - 1
            else:
                low = mid + 1
        
        return -1