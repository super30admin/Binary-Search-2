class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low,high = 0, len(nums)-1
        while low<=high:
            mid = low + (high - low)//2
            if (mid==high or nums[mid]>nums[mid+1]) and (mid == low or nums[mid]> nums[mid-1]):
                return mid
            elif nums[mid+1]>nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return -1
