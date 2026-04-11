# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Was trying to find both in one while, coulnt figure it out. 

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        low=0
        high=len(nums)-1
        s,e =-1,-1
        
        while (low <=high):
            mid = low+ (high-low)//2
            if target == nums[mid]:
                s=mid
                high = mid-1
            elif target > nums[mid]:
                low=mid+1
            else:
                high=mid-1

        if s!=-1:
            low = s
            high = len(nums)-1
            while (low <=high):
                mid = low+ (high-low)//2
                if target == nums[mid]:
                    e=mid
                    low = mid+1
                elif target > nums[mid]:
                    low=mid+1
                else:
                    high=mid-1

        
        return [s,e]