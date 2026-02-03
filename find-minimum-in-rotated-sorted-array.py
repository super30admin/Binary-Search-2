'''
Time Complexity : O(log n) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        lowest = 5001
        while low <= high:
            mid = high + (low - high) // 2
            
            if nums[low] <= nums[mid]:
                lowest = min(lowest, nums[low])
                low = mid + 1
            else:
                lowest = min(lowest, nums[mid])
                high = mid - 1
        
        return lowest
        