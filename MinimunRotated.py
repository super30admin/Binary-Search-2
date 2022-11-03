import math
class Solution:

    """
    Time complexity - O(n)
    """
    
    def searchMin(self, nums, low, end):
        mid = math.floor((low+end)/2)
        # if only 2 elements are left to search
        if mid == 0 or low == mid:
            return min(nums[low], nums[end])
        # if only one element is left
        if low == end:
            return nums[low]
        if low < end:
            # rotated case, and min is in between mid and end
            if nums[mid] > nums[end]:
                return self.searchMin(nums, mid+1, end)
            # rotated case and mid is the min
            elif nums[mid] < nums[mid-1]:     
                return nums[mid]
            # might or might not be rotated case, but min is in between start and mid-1
            else:
                return self.searchMin(nums, low, mid-1)
                
                     
        
    def findMin(self, nums: List[int]) -> int:
        return self.searchMin(nums, 0, len(nums)-1)
    
        