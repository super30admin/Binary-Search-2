# Time Complexity : O(Logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA


# Approach is to find the sorted side look for min if low is not the min then move to unsorted side and look for min then return the lowest element.

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=0
        n=len(nums)-1
        
        while(l<n):            
            m=l+(n-l)//2
            
            if(nums[m]>nums[n]):                   
                l=m+1
            else:
                n=m
        
        return nums[l]