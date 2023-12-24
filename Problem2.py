# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes the edge cases are not the best for this problem and seemed wastefule
# 153. Find Minimum in Rotated Sorted Array
# we are comapring to see if our middle index is ever greater then its right neighbor and if mid is less then its left neighbor this indicates the lowest value in a rotated sorted array

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1: # this is a edge case
            return nums[0]

        left = 0
        right = len(nums) - 1

        if nums[right] > nums[0]: # this is also a edge case
            return nums[0]

        while right >= left:
            mid = (left + right) // 2
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            elif nums[mid - 1] > nums[mid]:
                return nums[mid]
                
            if nums[mid] < nums[0]:
                right = mid - 1
            else:
                left = mid + 1