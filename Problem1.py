# Problem 1 - Find First and Last Position of Element in Sorted Array
# Time Complexity : O(log n) where n is the size of the nums list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
'''
First check if the number is out of range then return (-1, -1) and if it is in range then find first position of the element using binary search.
If the first position is -1 ie number does not exists in the array then no need to do binary search for the last position so return (-1,-1).
For the last position run separate binary search with low from first position
'''
# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # get the length of the nums list
        length = len(nums)
        # edge case if nums is None or the length is 0 then return [-1, -1]
        if nums is None or length == 0:
            return [-1, -1]
        # check if the target is out of range ie check if it is less than the first element or greater than last element of the array
        if target < nums[0] or target > nums[length-1]:
            # return [-1, -1]
            return [-1, -1]
        
        # binary search for the first position of the target in the nums
        def binarSearchFirst(nums: List[int], low: int, high:int, target: int) -> int:
            # loop until low <= high 
            while (low <= high):
                # get the middle element
                mid = low + (high - low) // 2
                # check if the number at middle position is equal to target
                if nums[mid] == target:
                    # if it is target then check if mid is 0 and prev element is not same as element at middle position
                    if mid == 0 or nums[mid] != nums[mid - 1]:
                        # if condition is true means it is the first position of the element so return middle index
                        return mid
                    else:
                        # else set the high to (mid-1)
                        high = mid - 1
                # check if the number at middle position is greater than the target
                elif nums[mid] > target:
                    # if it is then set the high to (middle-1)
                    high = mid - 1
                else:
                    # else set low to (mid+1)
                    low = mid + 1
            # if the number is not present then return -1
            return -1

        # binary search for the last position of the target in the nums
        def binarSearchLast(nums: List[int], low: int, high:int, target: int) -> int:
            # loop until low <= high 
            while (low <= high):
                # get the middle element
                mid = low + (high -low) // 2
                # check if the number at middle position is equal to target
                if nums[mid] == target:
                    # if it is target then check if mid is (length-1) and next element is not same as element at middle position
                    if mid == len(nums) - 1 or nums[mid] != nums[mid + 1]:
                        # if condition is true means it is the last position of the element so return middle index
                        return mid
                    else:
                        # else set the low to (mid+1)
                        low = mid + 1
                # check if the number at middle position is greater than the target
                elif nums[mid] > target:
                    # if it is then set the high to (mid-1)
                    high = mid - 1
                else:
                    # else set low to (mid+1)
                    low = mid + 1
            # if the number is not present then return -1      
            return -1
        # get the index of first position of the target with low as 0 and high as (length-1) 
        first = binarSearchFirst(nums, 0, length-1, target)
        # if the value of first is -1 means the target does not exists in the array
        if first == -1:
            # if it is then return [-1, -1]
            return [-1, -1]
        # get the index of last position of the target with low as first and high as (length-1) 
        last = binarSearchLast(nums, first, length-1, target)
        # return [first, last]
        return [first, last]
