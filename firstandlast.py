class Solution:
    
    def binarysearchFirst(self,nums:List[int],target):
        low=0
        high = len(nums)-1
        while low<=high:
            mid = int((low+high)/2)
            
            if nums[mid]==target:
                if mid ==low or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high=mid-1
                    
            elif nums[mid]<target:
                low = mid+1
                
            else:
                high = mid-1
                
        return -1
                
    def binarysearchSecond(self,nums,target,first):
        low=first
        high = len(nums)-1
        while low<=high:
            mid = int((low+high)/2)
            
            if nums[mid]==target:
                if mid ==high or nums[mid+1]>nums[mid]:
                    return mid
                
                else:
                    low=mid+1
                    
            elif nums[mid]<target:
                low = mid+1
                
            else:
                high = mid-1
                    
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low =0
        high = len(nums)-1
        
        if len(nums)==0:
            return [-1,-1]
        
        if target>nums[high] or target<nums[low]:
            return [-1,-1]
        
        first = self.binarysearchFirst(nums,target)
        
        if first == -1:
            return [-1,-1]
        
        second = self.binarysearchSecond(nums,target,first)
        
        return [first,second]