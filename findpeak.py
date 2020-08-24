# Time Complexity : O(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low < high:
            mid = low + (high-low) // 2
            
            if (nums[mid] > nums[mid+1]):
                high = mid
            else:
                low = mid + 1
        
        return low