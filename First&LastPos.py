#find first and second element if first element not found then second also doesn't exist
#to find first check mid if its target and mid-1 is less than mid/target return mid value else if target is greater than mid search right side else search left side
#when finding second element if mid is target value and mid+1 is greater than mid/target return mid else if target is greater tha mid search right side else search left side
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums==None or len(nums)==0:
            return [-1,-1]
        
        first=self.binarysearchfirst(nums,target)
        if first==-1:
            return [-1,-1]
        second=self.binarysearchsecond(nums,target)
        return [first,second]

    def binarysearchfirst(self,nums:List[int],target:int)-> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==low or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high=mid-1
            elif target>nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1
    
    def binarysearchsecond(self,nums:List[int],target:int)->int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==high or nums[mid+1]>nums[mid]:
                    return mid
                else:
                    low=mid+1
            elif target>nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1