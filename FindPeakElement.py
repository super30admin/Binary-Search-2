class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = low + (high - low) // 2
            if ((mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid] > nums[mid+1])):
                return mid
            elif nums[mid] > nums[mid+1]:
                high = mid - 1
            else:
                low = mid + 1
        return -1