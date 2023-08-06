#Time Complexity=O(logn)
#Space Complexity =o(1)
# Did this code successfully run on Leetcode : yes 
#Two Binary Searches

#Instead of using a linear-scan approach to find the boundaries once the target has been found, we can use two binary searches to find the first and last position of the target. We can find middle element

#Normally, we compare nums[mid] == target because we simply need to check if we found our target or not. But now, apart from checking for equality, we also need to check if mid is the first or the last index where the target occurs.

from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums==None or len(nums)==0:
            return [-1,-1]
        first=self.binarySearchFirst(nums,target)
        if first==-1:
            return [-1,-1]
        second=self.binarySearchSecond(nums,target)
        return[first,second]
    
    def binarySearchFirst(self,nums:List[int],taget:int)->int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==0 or nums[mid+1]<nums[mid]:
                    return mid
                else:
                    high=mid-1
            elif target>nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1
    
    def binarySearchSecond(self,nums:List[int],target:int)->int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid+1]>nums[mid]:
                    return mid
                else:
                    low=mid+1
            elif target>nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1