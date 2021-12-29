# avg TimeComplexity O(log n )
# SpaceComplexity O(1)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0: return -1
        if len(nums) == 1: return 0
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = (low+high)//2
            if (mid == len(nums)-1 or nums[mid] > nums[mid+1]) and (mid == 0 or nums[mid] > nums[mid-1]):
                return mid
            if nums[mid] < nums[mid+1]:
                low = mid+1
            else:
                high = mid-1