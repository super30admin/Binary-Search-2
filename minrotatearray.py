# Time Complexity : O(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def findMin(self, nums: List[int]) -> int:
        # Error case
        if len(nums) == 0 or nums == None :
            return -1
        
        if len(nums) == 1:
            return nums[0]
        
        #1
        low = 0
        high = len(nums) - 1
        
        if nums[low] < nums[high]:
            return nums[low]
        #2
        while high >= low:
            mid = low + (high - low) //2
            
            if mid>0 and nums[mid] < nums[mid -1]:
                return nums[mid]
            
            elif nums[mid] > nums[high]: low = mid + 1
            else: high = mid - 1
        
        return -1