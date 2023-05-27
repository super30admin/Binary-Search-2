"""
Problem : 3

Time Complexity : O(logn)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Checking base cases when the there is just one element in the array
Else checking the values adjacent to the middle value, if its the peak, 
then returning the mid value, else performing binary search on the either side
"""

class Solution(object):
    def findPeakElement(self, nums):
        l,r=0,len(nums)-1

        while l<r:
            mid=l+(r-l)//2
            if mid==0:
                if nums[0]>nums[1]:
                    return 0
                else:
                    return 1
            if nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1]:
                return mid
            if nums[mid]<nums[mid-1]:
                r=mid-1
            else:
                l=mid+1
        return l