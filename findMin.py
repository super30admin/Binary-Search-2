"""
#Approach:
We are using binary search to find the min in a rotated sorted array.  
We first check which half of the array has the minimum and based on that we change the start and end positions. 
After all iterations, we can get the min value at nums[start]

# Complexity
- Time complexity:
O(logn)

- Space complexity:
O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        start, end = 0, len(nums) - 1
        while(start < end):
            mid = start + (end - start)//2
            if nums[mid] < nums[end]:  # Minimum must be in the left half (including mid)
                end = mid
            else: # Minimum must be in the right half
                start = mid + 1
        return nums[start]

nums = [4,5,6,7,0,1,2]
sol = Solution()
print(sol.findMin(nums))