class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        low = 0 
        n = len(nums)
        high = n-1
        while low <= high:
            mid = low + (high - low) // 2
            if (((mid == low) or (nums[mid - 1] < nums[mid])) and ((mid == high) or (nums[mid + 1] < nums[mid]))):
                return mid
            elif nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1