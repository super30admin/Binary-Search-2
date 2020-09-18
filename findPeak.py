"""
Time Complexity : O(LogN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low = 0
        high = len(nums) - 1
        while(low < high):
            
            mid = low + (high - low) // 2
            
            if(nums[mid] >= nums[mid + 1]):
                high = mid
            else:
                low = mid + 1
                
        return low
        