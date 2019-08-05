class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        fIndex=  self.firstIndex(target,nums)
        Lindex=  self.LastIndex(target,nums)
        return(fIndex,Lindex)
   
   
        # we are going to do a bunary search, compare the middle element with the target and move the pointer accordingly and then conduct binary search in that range
    def firstIndex(self, target, nums):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid= (low+high)//2  #finding the middle index
            
            if nums[mid]==target:
                if mid==low or nums[mid-1]<nums[mid]:#condition for the first index    
                    return mid 
                else:
                    high=mid-1
            elif nums[mid]>target:  #if the middle element is not equal to target
                high=mid-1
            else:
                low =mid +1
        return -1
    
    def LastIndex(self,target,nums):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid= (low+high)//2  #finding the middle index
            
            if nums[mid]==target:
                if mid==high or nums[mid+1]>nums[mid]:#condition for the last index    
                    return mid 
                else:
                    low=mid+1
            elif nums[mid]>target:  #if the middle element is not equal to target
                high=mid-1
            else:
                low =mid +1
        return -1
                