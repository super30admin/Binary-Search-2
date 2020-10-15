"""
Time Complexity : O(log n)
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach
So for this question, we applied an approch to use binary search 2 times. One to find leftmost occurance
and one to find rightmost occurance. 
"""


class Solution(object):
    def searchLeft(self, nums, target):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1

    def searchRight(self, nums, target):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == high or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid+1
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums:
            return [-1, -1]
        left = self.searchLeft(nums, target)
        right = self.searchRight(nums, target)
        return [left, right]
