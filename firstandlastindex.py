# Time complexity - O(n)
# Space complexity - O(1)

# Ran on Leetcode - Yes

# Couldn't figure out binary search method in 30 mins.


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        final = [-1,-1]
        
        for i,no in enumerate(nums):
            if no==target:
                final[0] = i
                break
            
        for j,no in enumerate(nums[::-1]):
            if no == target:
                final[1] = len(nums) - j -1
                break
                
        if -1 in final:
            return [-1,-1]
        
        return final
        
            