# Time Complexity : Ideally it is 2Log(n) but constant doesn't maater hence it is O(log n) as we dividing the array in each iteration. 
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :
from typing import List

class Solution:
    def firstElementBinarySearch(self,nums: List[int], Low:int, High:int, target :int ):
        while(Low<=High):
            Mid = Low + (High-Low)//2
            if nums[Mid]==target:
                while Mid !=0 and (nums[Mid] == nums[Mid-1]):               
                    Mid= Mid-1
                return Mid                
            if target <= nums[Mid]:
                High = Mid-1
            else:
                Low = Mid+1
        return -1
    
    def lastElementBinarySearch(self,nums: List[int], Low:int, High:int, target :int ):
        while(Low<=High):
            Mid = Low + (High-Low)//2
            if nums[Mid]==target:
                while Mid !=len(nums)-1 and (nums[Mid] == nums[Mid+1]):               
                    Mid= Mid+1
                return Mid                
            if target <= nums[Mid]:
                High = Mid-1
            else:
                Low = Mid+1
        return -1
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums)==0:
            return -1, -1
        firstElement = self.firstElementBinarySearch(nums,0,len(nums)-1,target)
        lastElement = self.lastElementBinarySearch(nums,firstElement,len(nums)-1,target)
        return firstElement, lastElement
        
        
        
obj = Solution()
print(obj.searchRange([1],1))
print(obj.searchRange([5,7,7,8,8,10],6))
print(obj.searchRange([5,7,7,8,8,10],8))