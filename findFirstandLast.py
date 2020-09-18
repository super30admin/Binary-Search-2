"""
Time Complexity : O(LogN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def findtarget(nums, target):
            low = 0
            high = len(nums) - 1
            found = len(nums)

            while(low <= high):

                mid = low + (high - low) // 2
                if(nums[mid] >= target):
                    found = mid
                    high = mid - 1
                else:
                    low = mid + 1
            return found
        
        first_pos = findtarget(nums, target)
        last_pos = findtarget(nums, target +1) - 1
        if(first_pos <= last_pos):
            return [first_pos, last_pos]
        else:
            return [-1,-1]
        