"""
Problem : 2

Time Complexity : O(logn)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Finding whether the middle element falls in the sorted part of the array or not
if yes, then searching the other part as the leftmost element must be greater than the min element
hence it can be found on the other side
"""

class Solution(object):
    def findMin(self, nums):
        l,r=0,len(nums)-1
        res=nums[l]
        while l<=r:
            if nums[l]<nums[r]:
                res=min(res,nums[l])
                break
            mid=l+(r-l)//2
            res=min(nums[mid],res)
            
            if nums[mid]>=nums[l]:
                l=mid+1
            else:
                r=mid-1
        return res
