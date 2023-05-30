

#Time Complexity : O(logn)
#Space Complexity : O(1)

#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)//2
            if mid>0 and nums[mid]<nums[mid-1]:
                h=mid-1
            elif mid<len(nums)-1 and nums[mid]<nums[mid+1]:
                l=mid+1
            else:
                return mid
            