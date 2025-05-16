"""
Time Complexity: O(log n)
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes  
Any problem you faced while coding this : No

 # Uses binary search to find the rotation point where 
 # the smallest element exists in a rotated sorted array.
"""
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        left = 0
        right = len(nums) - 1

        if len(nums) == 1 or nums[right] > nums[0]:
            return nums[0]

        while left <= right:
            mid = left + (right-left)//2
            if nums[mid] < nums[mid-1]:
                return nums[mid]
            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
            if nums[mid] > nums[0]:
                left = mid+1
            else:
                right = mid-1
            


        