# Time Complexity :O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

#Approach:- find left most and right most element using binary search,continue even if we find the target
def bsearch(nums,target,left_side):
        (l,r)=(0,len(nums)-1)
        index=-1
        while(l<=r):
            m= l+(r-l)//2
            if(nums[m]<target):
                l=m+1
            elif(nums[m]>target):
                r=m-1
            else:
                index=m
                if(left_side):
                    r=m-1
                else:
                    l=m+1
        return index
class Solution(object):
    def searchRange(self, nums, target):
        left=bsearch(nums,target,True)
        right=bsearch(nums,target,False)
        return([left,right])
                