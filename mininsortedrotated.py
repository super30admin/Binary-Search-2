class Solution:
    def findMin(self, nums: List[int]) -> int:
        low =0
        high = len(nums)-1
        
        if len(nums)==0:
            return - 1
        
        while low<=high:
            if nums[low]<= nums[high]:
                return nums[low]
            mid = int((low+high)/2)
            print(mid)
            
            if (mid==low or nums[mid-1]>nums[mid]) and (mid==high or nums[mid+1]>nums[mid]):
                return nums[mid]
            
            elif nums[mid]>=nums[low]:
                low =mid+1
                
            else:
                high=mid-1
                
        return -1
                