# Time Complexity :O(log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def findMin(self, nums):
        n=len(nums)
        (l,r) =(0,n-1)
        while(l<=r):
            if(nums[l]<nums[r]):
                return(nums[l])
            mid=l+(r-l)//2
            if((mid==0 or nums[mid-1]>nums[mid]) and (mid==n-1 or nums[mid+1]>nums[mid])):
                return(nums[mid])
            elif(nums[l]<=nums[mid]):
                l=mid+1
            else:
                r=mid-1
        return(324)