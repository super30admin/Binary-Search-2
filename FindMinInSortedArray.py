# Time Complexity : It is O(log n) as we dividing the array in each iteration.
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        Low = 0 
        High = len(nums) -1
        
        if(len(nums)==1 or nums[Low]<nums[High]):
            return nums[Low]       
        
        while(Low<=High):
            Mid = Low + (High-Low)//2
            
            if nums[Mid-1] > nums[Mid]:
                return nums[Mid]
            if nums[Mid] > nums[Mid +1]:
                return nums[Mid +1]
          
                 
            if(nums[Low]<nums[Mid]):
                Low = Mid + 1
            else:
                High = Mid -1

        return nums[Mid]
        
obj = Solution()
print(obj.findMin([3,1,2]))
print(obj.findMin([2,1,3,4]))