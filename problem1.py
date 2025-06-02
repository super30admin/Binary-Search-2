# // Time Complexity :O(Logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


# // Your code here along with comments explaining your approach in three sentences only
# In this problem there will be two BS searching for both 1st and last elements. For 1st ele we will coampre it with prev ele and based on that we will move left . for last ele we will
# comapre it with right ele and based on that we will move to right
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l,h=0,len(nums)-1
        ans_low=-1
        ans_high=-1
        #binary search for 1st ele
        while(l<=h):
            mid=l +(h-l)//2
            if mid==0 and nums[mid]==target :
                ans_low=mid
                break
            if nums[mid]==target and nums[mid-1]<nums[mid]:
                ans_low=mid
                break
            elif nums[mid]==target and nums[mid-1]==nums[mid]:
                h=mid-1
            elif nums[mid]<target:l=mid+1
            else:
                h=mid-1
        if ans_low==-1:return [-1,-1]
        l,h=ans_low,len(nums)-1
        while(l<=h):
            mid=l +(h-l)//2
            if mid==len(nums)-1 and nums[mid]==target :
                ans_high=mid
                break

            if nums[mid]==target and nums[mid+1]>nums[mid]:
                ans_high=mid
                break
            elif nums[mid]==target and nums[mid+1]==nums[mid]:
                l=mid+1
            elif nums[mid]<target:l=mid+1
            else:
                h=mid-1
        return [ans_low,ans_high]

                

        
