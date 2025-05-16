"""
Time Complexity: O(log n)
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

#  Performs two binary searches:
#  - First to find the leftmost occurrence of the target.
#  - Second to find the rightmost occurrence.
"""
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums:
            return [-1, -1]

        left, right = -1, -1
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        if low < len(nums) and nums[low] == target:
            left = low
        else:
            return [-1, -1]

       
        high = len(nums) - 1  
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        right = high

        return [left, right]