"""
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums)-1
        self.ans = [-1,-1]
        self.binary(nums, target, left, right, True)
        self.binary(nums, target, left, right, False)
        return self.ans
        
    
    def binary(self, nums, target, left, right, isLeft):
        while (left <= right):
            mid = left +(right-left)//2
            if nums[mid] == target:
                if (isLeft):
                    self.ans[0] = mid
                    right = mid -1
                else:
                    self.ans[1] = mid
                    left = mid + 1
                    
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid -1
        return 