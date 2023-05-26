'''
Problem: Find Minimum in Rotated Sorted Array
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
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1
        ans = 0

        if len(nums) == 1:
            return nums[0]

        if nums[right]> nums[0]:
            return nums[0]

        while left<=right:
            mid = (left+right)//2
            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
                
            if nums[mid]< nums[mid-1]:
                return nums[mid]

            if nums[mid] > nums[0]:
                left = mid+1
            else:
                right = mid-1