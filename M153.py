# TC : O(logn)
# SC : O(1)
# Leet code : Yes
# problems : -
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low)//2
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                if nums[mid]<=nums[low] and nums[mid-1]>nums[mid]:
                    return nums[mid]
                else:
                    high = mid - 1