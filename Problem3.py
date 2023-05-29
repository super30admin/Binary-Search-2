# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We can use binary search in this case. We check if the midpoint is the peak, ie, greater than its neighbours.
# If not, then we decide to go the side that is higher than the `mid` value. 
# This ensures that we will eventually find "a" peak and we can safely ignore the other half.

class Solution:

    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0

        l, h = 0, len(nums)-1
        
        while l <= h:
            m = l + (h-l)//2
            if (m==0 or nums[m-1] < nums[m]) and (m==len(nums)-1 or nums[m] > nums[m+1]):
                return m
            elif m > 0 and nums[m-1] > nums[m]:
                h = m - 1
            else:
                l = m + 1
        
        return -1

