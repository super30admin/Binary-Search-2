# Problem 3 - Find Peak Element
# Time Complexity : O(log n) where n is the size of the nums list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
'''
Run the binary search on the nums list. Get the middle element and check if it is greater than the neighbours, if it is then found the peak element.
If not then check if the previous element is greater than middle element if it is then search in the left side else search in right side.
'''
# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # get the length of the nums
        length = len(nums)
        # set low to 0
        low = 0 
        # set high to (length-1)
        high = length - 1
        # loop till low <= high
        while low <= high:
            # get the middle element
            mid = low + (high-low) // 2
            # check the boundary with mid and check if the element at middle position is greater than the previous elements and next element
            if (mid == 0 or nums[mid] >nums[mid-1]) and (mid == length-1 or nums[mid] > nums[mid+1]):
                # if the condition is true then return middle value
                return mid
            # check if the middle is gerater than 0 and element at middle is less than the previous element then search in the left side
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                # set the high to (mid-1)
                high = mid - 1
            else:
                # else search in the right side ie low to mid + 1
                low = mid + 1
        # return random number 999
        return 999
