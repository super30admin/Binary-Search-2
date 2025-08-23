# Time Complexity : O(logN) where N is the length of the array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using two binary search functions to find the lower and upper bounds of the target. I first find the lower bound using a binary search
# and then the upper bound by using the binary search. Then check if the lower and upper bounds are valid. There are few optimizations possible like
# rather then starting from the low again I can start from the lower bound I found before. And doing it in a single function rather then two functions.
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def lowerbound():
            low = 0
            high = len(nums) - 1
            firstPos = -1
            while low <= high:
                mid = low + (high - low)//2
                if nums[mid] >= target:
                    if nums[mid] == target:
                        firstPos = mid
                    high = mid - 1
                else:
                    low = mid + 1
            return firstPos
        def upperbound():
            low = 0
            high = len(nums) - 1
            lastPos = -1
            while low <= high:
                mid = low + (high - low) //2
                if nums[mid] <= target:
                    if nums[mid] == target:
                        lastPos = mid
                    low = mid + 1
                else:
                    high = mid - 1
            return lastPos
        lb = lowerbound()
        if lb == -1:
            return [-1,-1]
        ub = upperbound()
        return [lb,ub]




        