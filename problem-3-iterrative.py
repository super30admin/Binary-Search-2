"""
Approach

1. Find the middle element and if its greater than both of its neighbours then return mid which is the peak
2. If middle element is not the peak then either of left or right neighbours of mid must be graeter than the mid. and the peak always lies on the side of the neighbour which is greater than the middle element.
3. Find which neighbour is greater than the middle lement and perform binary search on that side to find the peak.
"""


# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        r = len(nums)-1
        while l<=r:
            m = l+(r-l)//2            
            if (m==0 or nums[m]>nums[m-1]) and (m==len(nums)-1 or nums[m]>nums[m+1]):
                return m          
            if (m > 0 and nums[m-1]>nums[m]):
                r= m-1
            else:
                l = m+1
        return -1
                  
        