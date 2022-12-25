# Time Complexity :O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

#Approach:- Search in the direction where the slope is increasing that is the value next to the mid is increasing



class Solution(object):
    def findPeakElement(self, nums):
        (l,r)=(0,len(nums)-1)
        
        while l<r:
            mid=(l+r)//2
            if(nums[mid] == max(nums[mid],nums[mid-1],nums[mid+1])):
                return mid
            elif(nums[mid+1]>=nums[mid-1]):
                l=mid +1
            else:
                r=mid-1
        return l
        
     