class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==1: return nums[0]

        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = lo + (hi-lo)//2
            if nums[lo] <= nums[hi]: return nums[lo]
            if nums[lo] <= nums[mid]:
                lo = mid+1
            else:
                hi = mid
        return nums[lo]
