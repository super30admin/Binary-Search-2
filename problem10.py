
#Time Complexity : O(logn)
#Space Complexity : O(1)

#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        res=nums[0]
        while low<=high:
            if nums[low]<nums[high]:
                res=min(res,nums[low])
                break
            mid=(low+high)//2
            res=min(res,nums[mid])
            if nums[mid]>=nums[low]:
                low=mid+1
            else:
                high=mid-1
        return res