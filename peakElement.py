"""
#Approach:
We are using binary search to find the peak in a array.  
After calculating the mid point, we comapre the nums[mid] with nums[mid + 1] to find on which side we the peak.
Based on the side we change the start and end point and at last start point will give one of the peak if exists 

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
    def findPeak(self, nums: List[int]) -> int:
        start, end = 0, len(nums) - 1
        while(start < end):
            mid = start + (end - start)//2
            if nums[mid] > nums[mid + 1]:  # peak must be in the left half (including mid)
                end = mid
            else: # peak must be in the right half
                start = mid + 1
        return nums[start]

nums = [1,2,1,3,5,6,4]
sol = Solution()
print(sol.findPeak(nums))