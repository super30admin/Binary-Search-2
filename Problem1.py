'''
Problem: Find First and Last Position of Element in Sorted Array
Time Complexity : O(log n), where n is given elements
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
        Applied two binary search
        One to find left index
        Another to find right index    
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def getleft(nums, target):
            left = 0
            right = len(nums)-1
            while left<=right:
                mid = (left+right)//2
                if target>nums[mid]:
                    left = mid+1
                else:
                    right = mid-1
            return left
        
        def getright(nums, target):
            left = 0
            right = len(nums)-1
            while left<=right:
                mid = (left+right)//2
                if target>=nums[mid]:
                    left = mid+1
                else:
                    right = mid-1
            return right

        left = getleft(nums, target)
        right = getright(nums, target)

        if left<=right:
            return [left,right]
        else:
            return [-1,-1]
