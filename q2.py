from typing import List
#Time Complexity :O(log(n))
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Not anything specific
'''Approach:
For Finding the Finding the minimum in the rotated sorted array approach is very similar to finding a element in rotated sorted array
''' 
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        while(l<=r):
            if(l==r):
                 return nums[l]
            if(r==l+1):
                return(min(nums[l],nums[r]))
            #print(l,r)
            mid=(l+r)//2
            #print(mid)
            if(nums[mid]>=nums[l]):
                #Here the left side will have the sorted elements,
                    
                if(nums[mid]<nums[r]):
                    #This is a special case where all the elements are in increasing order
                    return nums[0]
                #But we have to find the minimum from mid,right side
                l,r=mid,r
                continue
            if(nums[mid]<nums[l]):
                #Here the right side will have the sorted elements
                    
                if(nums[mid]>nums[r]):
                    #This is a special case where all the elements are in decesending order
                    return nums[-1]
                #But we have to find the minimum from mid,left side
                l,r=l,mid
                continue
            
                
                
        