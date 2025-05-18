class Solution:

    def isPeak(self, nums, i):
        if i == 0 and nums[i] >  nums[i+1]:
            return True
        if i == len(nums)-1 and nums[i] > nums[i-1]:
            return True
        return nums[i-1] < nums[i] > nums[i+1]

    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1 
        if len(nums) == 1:
            return 0

        while low <= high:
            mid = low + (high-low)//2
            if self.isPeak(nums, mid):
                return mid
            if nums[mid+1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1

