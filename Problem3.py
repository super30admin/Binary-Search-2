# Time Complexity: O(log N)
# At each step search space is halfed. Binary Search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# Using Binary search strategy we can do this in O(log N) time complexity. By running the while loop as long as low <= high
# Calculate mid as below to avoid integer overflows
# If nums[mid] < nums[mid-1] peak is on the left or if nums[mid] < nums[mid + 1] peak is on right

from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if(mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid > 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            else:
                low = mid + 1
        return -1