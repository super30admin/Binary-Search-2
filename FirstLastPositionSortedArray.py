class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(nums==None or len(nums)==0):
            return [-1,-1]
        first=self.bsFirst(nums,target)
        if(first==-1):
            return [-1,-1]
        second=self.bsSecond(nums,target)
        return [first,second]
    def bsFirst(self,nums: List[int], target: int)->int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target):
                if(mid==0 or nums[mid-1]<target):
                    return mid
                high=mid-1
            elif (target>nums[mid]):
                low=mid+1
            else:
                high=mid-1
        return -1
    def bsSecond(self,nums:List[int],target:int)->int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target):
                if(mid==len(nums)-1 or nums[mid+1]>target):
                    return mid
                low=mid+1
            elif (target>nums[mid]):
                low=mid+1
            else:
                high=mid-1
        return -1