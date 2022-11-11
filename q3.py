import sys
from typing import List
#Time Complexity :O(log(n))
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Not anything specific

'''
Approach:
Here the idea is At the given point, We reach peek only if we move in the positive slope direction.'''

class Solution:
    #This is just a function which will return the values, Time Complexity is O(1) 
    def getelementfromnums(self,nums: List[int],index: int)->int:
        n=len(nums)
        if(index in range(0,n)):
            return nums[index]
        if(index>=n or index<0):
            return -sys.maxsize
            
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        while(l<=r):
            #print(l,r)
            mid=(l+r)//2
            if(self.getelementfromnums(nums,mid)>self.getelementfromnums(nums,mid-1) and self.getelementfromnums(nums,mid)>self.getelementfromnums(nums,mid+1)):
                #Here we already at one of the peek
                return mid
            if(self.getelementfromnums(nums,mid+1)>self.getelementfromnums(nums,mid) and self.getelementfromnums(nums,mid)>self.getelementfromnums(nums,mid-1)):
                #Here we can move on right side 
                l,r=mid+1,r
                
            if(self.getelementfromnums(nums,mid-1)>self.getelementfromnums(nums,mid) and self.getelementfromnums(nums,mid)>self.getelementfromnums(nums,mid+1)):
                #Here we can move on left side
                l,r=l,mid-1
                
            if(self.getelementfromnums(nums,mid)<self.getelementfromnums(nums,mid+1) and self.getelementfromnums(nums,mid)<self.getelementfromnums(nums,mid+1)):
                #Here either move on left or right side
                #Just for time being we moving to right
                l,r=mid+1,r