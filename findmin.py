#Time Complexity=O(logn)
#Space Complexity =O(1)
#// Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low,high=0,len(nums)-1
        n=len(nums)
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]<=nums[(mid-1+n)%n] and nums[mid]<=nums[(mid+1)%n]:
                return nums[mid]
            if nums[mid]>=nums[low]:
                if nums[high]>=nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                high=mid-1

        return -1
