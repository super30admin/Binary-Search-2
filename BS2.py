# Time Complexity : O(logN) where N is the size of list 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a binary search approach to find the minimum element in a rotated sorted array. 
# If the element is found I store it in the low pointer value and then return that. 

from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) //2
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid - 1
        return nums[low]
        