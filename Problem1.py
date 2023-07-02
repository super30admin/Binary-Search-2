#Time Complexity :O(log n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#For Finding the peak we will use binary search, we select a sub array with slope having higher value
class Solution:
    def binarySearchFirstIndex(self,low,high,nums,target):
        while(low<=high):
             mid=int(low+(high-low)/2)
             if(nums[mid]==target):
                 if(mid==0 or nums[mid-1]!=target):
                    return mid
                 else:
                     high=mid-1
             elif (target<nums[mid]) :
                 high=mid-1
             else:
                 low= mid+1
        return -1

    def binarySearchLastIndex(self,low,high,nums,target):
        if low==-1:
            return -1
        while(low<=high):
             mid=int(low+(high-low)/2)
             if(nums[mid]==target):
                 if(mid==high or nums[mid+1]!=target):
                    return mid
                 else:
                     low=mid+1
             elif (target>nums[mid]) :
                 low= mid+1
             else:
                 high=mid-1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None:
            return [-1,-1]
        
        low=0
        high=len(nums)-1
        
        FirstIndex=self.binarySearchFirstIndex(low,high,nums,target)
        LastIndex=self.binarySearchLastIndex(FirstIndex,high,nums,target)

        return [FirstIndex,LastIndex]
      