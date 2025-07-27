#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low=0
        high=len(nums)-1

        while low<=high:
            mid=low+(high-low)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]): # check of mid is the peak element 
                return mid 
            elif nums[mid]<nums[mid+1]:           # check which side it is increasing
                low=mid+1                         # if right side is increasing then shift to that side 
            else:
                high=mid-1                        # if left side is increasing then shift to that side 
        return -1
        