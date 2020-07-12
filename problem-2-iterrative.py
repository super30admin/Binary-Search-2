"""
Approach

1. Find the middle element and if its less than both of its neighbours then return mid
2. One of the property of roatated sorted array is that either the left part or the right part of the mid is always sorted
3. if the left part is sorted and then the deflection point will be on right and if the right part is sorted then the deflection point will be on left
based on the the decision of which part is sorted, perform binary search on the remaining part to find the minimum element

"""


# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=0
        r = len(nums)-1
        while l<=r:
            m = l+(r-l)//2            
            if (m==0 or nums[m-1]>nums[m]) and (m==len(nums)-1 or nums[m]<nums[m+1]):
                return nums[m]          
            if (nums[r]>nums[m]):
                r= m-1
            else:
                l = m+1
        return -1