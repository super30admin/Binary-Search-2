#Time Complexity=O(logn)
#Space Complexity =o(1)
# Did this code successfully run on Leetcode : yes 

from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==0 and nums==None:
            return -1
        low=0
        high=len(nums)-1

        while low<=high:
            if nums[low]<=nums[high]:
                return nums[low]
            mid=low+(high-low)//2 
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]

            if nums[low]<=nums[mid]:
                low=mid+1
            else:
                high=mid-1

        return 4545656