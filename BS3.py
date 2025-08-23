# Time Complexity : O(logN) where N is the size of list 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
#I am using a binary search approach to find the peak element in an array. I am checking if the middle element is greater than its neighbors.
# If it is greater than both neighbors, then it is a peak element. Else eliminate one half of the search space.

from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) //2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid != 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            else:
                low = mid + 1
        return 278722