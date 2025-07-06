# Time Complexity : It is O(log n) as we dividing the array in each iteration.
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        Low =0 
        High = len(nums) -1

        if len(nums)==1:
            return 0
        
        if len(nums)==2 and nums[0] > nums[1]:
            return 0
        if len(nums)==2 and nums[0] < nums[1]:
            return 1

        while(Low<=High):
            Mid = Low + (High-Low)//2
            
            if Mid==0 and nums[Mid]<nums[Mid+1]:
                return Mid
            
            if Mid==len(nums) -1 and nums[Mid]>nums[Mid-1]:
                return Mid
            
            if(nums[Mid-1]<nums[Mid]>nums[Mid+1]):
                return Mid
                        
            if (nums[Mid]<nums[Mid-1]):
                High=Mid-1
            else :
         
                Low=Mid+1
            
        return -1
        

obj = Solution()
print(obj.findPeakElement([2,1,2]))