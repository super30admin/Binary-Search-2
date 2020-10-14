#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        left, right = 0, len(nums)-1
        leftIndex = self.findFirstIndex(nums, left, right, target)
        rightIndex = self.findLastIndex(nums, left, right, target)
        return [leftIndex, rightIndex]

    def findFirstIndex(self, nums, left, right, target):
        res = -1
        while left <= right:
            mid = left + (right-left)//2
            if nums[mid] == target:
                res = mid
                right = mid-1
            elif nums[mid] > target:
                right = mid-1
            else:
                left = mid + 1
        return res

    def findLastIndex(self, nums, left, right, target):
        res = -1
        while left <= right:
            mid = left + (right-left)//2
            if nums[mid] == target:
                res = mid
                left = mid+1
            elif nums[mid] > target:
                right = mid-1
            else:
                left = mid + 1
        return res
