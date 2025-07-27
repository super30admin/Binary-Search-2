#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low=0
        high=len(nums)-1
        while low<=high:
            if nums[low]<=nums[high]:   # check if it sorted then return the min directly
                return nums[low]
            mid=low+(high-low)//2
            if (mid==0 or nums[mid]<nums[mid+1]) and (mid==len(nums)-1 or nums[mid]<nums[mid-1]): # check of mid is the element 
                return nums[mid]
            if nums[low]<=nums[mid]:                 # if left side is sorted then the min is in the right side 
                low=mid+1
            else:
                high=mid-1                           # if the right side is sorted then the min is the left side 
        return -1
