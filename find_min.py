class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        if(len(nums)==0 or nums==None):
            return 
        
        while(l<=h):
            if(nums[l]<=nums[h]):
                return nums[l]
            
            mid= l+(h-l)//2
            if(mid!=0 and mid != h and nums[mid-1]>nums[mid] and nums[mid]<nums[mid+1]):
                break
            if(nums[l]<=nums[mid]):
                l=mid+1
            else:
                h=mid-1
        
        return nums[mid]