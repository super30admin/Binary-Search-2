class Solution:
    def findFirst(self,nums,target):
        low=0
        high=len(nums)-1

        while low<=high:
            mid=(low+high)//2
            if target==nums[mid]:
                if mid==low or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high=mid-1
            elif target<nums[mid]:
                high=mid-1
            else:
                low=mid+1

        return -1

    def findSecond(self,nums,target,low):
        low=low
        high=len(nums)-1

        while low<=high:
            mid=(low+high)//2
            if target==nums[mid]:
                if mid==high or nums[mid+1]>nums[mid]:
                    return mid
                else:
                    low=mid+1
            elif target<nums[mid]:
                high=mid-1
            else:
                low=mid+1
                
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low=0
        high=len(nums)-1

        if nums==None or len(nums)==0:
            return [-1,-1]
            
        if target<nums[low] or target>nums[high]:
            return [-1,-1]
        else:
            firstIndex=self.findFirst(nums,target)

            if firstIndex!=-1:
                secondIndex=self.findSecond(nums,target,firstIndex)
            
            if firstIndex!=-1 and secondIndex!=-1:
                return [firstIndex,secondIndex]
            elif firstIndex!=-1 and secondIndex==-1:
                return [firstIndex,-1]
            else:
                return [-1,-1]
        



        