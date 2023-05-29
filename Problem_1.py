"""
Problem : 1

Time Complexity : O(logn)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Performing binary search to find the leftmost occurence of the target when
then performing binary search to find the rightmost occurence of the target
"""

class Solution(object):
    def searchRange(self, nums, target):
        # finding the leftmost occurance of the target
        l,r=0,len(nums)-1
        left=-1
        while l<=r:
            mid=l+(r-l)//2
            if nums[mid]==target:
                # found the target but still need to find the leftmost occurance
                left=mid
                # hence decrease the right pointer by 1 before mid
                r=mid-1
            elif nums[mid]>target:
                r=mid-1
            else:
                l=mid+1
                
        # finding the rightmost occurance of the target
        l,r=0,len(nums)-1
        right=-1
        while l<=r:
            mid=l+(r-l)//2
            if nums[mid]==target:
                # found the target but still need to find the rightmost occurance
                right=mid
                # hence increase the left pointer by 1 after mid
                l=mid+1
            elif nums[mid]>target:
                r=mid-1
            else:
                l=mid+1
                

        
        return [left,right]
    

