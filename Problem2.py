# Time Complexity: O(log N)
# At each step search space is halfed. Binary Search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# Binary search approach, continuing the while loop low < high 
# And compare nums[mid] with nums[high], if nums[mid] > nums[high] minimum is right to mid 
# if nums[mid] <= nums[high] minimum is at mid or to the left

from typing import List
class Solution:
    def findMin(self, nums: List[int]):
        low = 0
        high = len(nums) - 1
        while(low < high):
            mid = low + (high - low) // 2
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        return nums[low]