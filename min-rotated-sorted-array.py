class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, len(nums)-1
        
        while start <= end:
            mid = start + (end - start) // 2
            
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums) - 1 or nums[mid+1] > nums[mid]):
                return nums[mid]
            if nums[mid] < nums[end]:
                end = mid - 1
            else: start = mid + 1
        return -1
