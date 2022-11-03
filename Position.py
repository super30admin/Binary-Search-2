
import math
class Solution:  
    """
    Time complexity - O(logn)
    """ 
    
    def search_start_index(self,nums,start,end,target):
        mid = math.floor((start+end)/2)
        # if mid is target, check if it is the first position of target
        if(nums[mid] == target):
            if (mid != 0 and nums[mid-1] != target) or (mid == 0):
                return mid
        if start <= end:
            # search in left half of list if targt is less than value at mid
            if nums[mid] >= target:
                return self.search_start_index(nums, start, mid-1, target)
            else:
                # search in righ half of list if targt is greater than value at mid
                return self.search_start_index(nums, mid+1, end, target)
        return -1
    
    def search_end_index(self,nums,start, end, target):
        mid = math.floor((start+end)/2)
        if(nums[mid] == target):
            if (mid != len(nums)-1 and nums[mid+1] != target) or (mid == len(nums)-1):
                return mid
        if start <= end:
            if nums[mid] > target:
                return self.search_end_index(nums, start, mid-1, target)
            else:
                return self.search_end_index(nums, mid+1, end, target)
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        start_index = self.search_start_index(nums,0,len(nums)-1,target)
        end_index = self.search_end_index(nums,0,len(nums)-1,target)
        return [start_index,end_index]
            
        
        
        