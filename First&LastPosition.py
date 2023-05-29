# Time Complexity : O(Logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to find the first occurance and second time do the binary search for target+1 then reduce 1 from the returned index.

class Solution(object):
    def find(self, nums,target):
        l=0
        h=len(nums)
        while (l<h):
            m=(l+h)//2
            if(nums[m]<target):
                l=m+1
            else:
                h=m
        return l

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        l=self.find(nums, target)
        h=self.find(nums, target+1)-1
        if(l<=h):
            return (l,h)
        
        return(-1,-1)
