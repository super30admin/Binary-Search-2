# Time Complexity : O(Logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

#Approach is to compare mid and mid+1 using binary search then if mid+1 is great then move the low to mid+1 else move to the left side by moving high to mid-1.

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=0
        h=len(nums)-1
        
        while(l<h):
            m=l+(h-l)//2
            print(m)
            if(nums[m]<nums[m+1]):
                l=m+1
            elif(nums[m-1]>nums[m]):
                h=m-1
            else:
                return m
        return l