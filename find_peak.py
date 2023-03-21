# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""Here we are using binary search to find the peak element. We are checking if the mid element is greater
 than its neighbours. If it is, we return the index. If it is not, we check if the element to the right is
   greater than the mid element. If it is, we move the low pointer to mid+1. If it is not, we move the high 
   pointer to mid-1."""

import sys

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0:
            return(int(sys.maxsize))
        
        if len(nums) == 1:
            return 0

        if nums[0] > nums[1]:
            return 0

        if nums[-1] > nums[-2]:
            return len(nums)-1

        low, high = 0, len(nums)-1

        while low <= high:
            mid = (low+high)//2

            if nums[mid-1] < nums[mid] > nums[mid+1]:
                return mid
            elif nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1
