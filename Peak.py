import math
class Solution:
    """
    Time complexity - O(n)
    """
    
    def findPeak(self, nums, start, end):
        mid = math.floor((start+end)/2)
        # mid can be 0 not just because nums[mid] is greater.
        # it can be 0 when len(nums) is 2 or when onoy first 2 elements are considered
        if mid == 0 and end-start == 1:
            if nums[start] > nums[end]:
                return start
            return end
        # if mid is peak and only element left to search
        if (mid == 0) or mid == (len(nums)-1):
            return mid
        # if mid is peak 
        elif nums[mid] > max(nums[mid-1], nums[mid+1]):
            return mid
        else:
            if nums[mid+1] > nums[mid]:
                # search in right array for peak
                return self.findPeak(nums, mid+1, end)
            else:
                # search in left array for peak
                return self.findPeak(nums, start, mid-1)
        return -1
         
    def findPeakElement(self, nums: List[int]) -> int:
        return self.findPeak(nums, 0, len(nums)-1)
    
    
    