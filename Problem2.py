# Problem 2 - Find Minimum in Rotated Sorted Array
# Time Complexity : O(log n) where n is the size of the nums list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
'''
First will check if the range is sorted, if it is then resturned the element at low position. If not then will do binary search.
Get the middle element and chek if it is less than its neighbouring element and if it is then it is a minimum value of the array so return it.
If not then we check which part is sorted and set the low and high pointer in the other part since minimum is always in unsorted array.
'''
# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        # get the length of the nums array
        length = len(nums)
        # set the low to 0 and high to (length - 1) ie at end of the array
        low = 0
        high = length -1
        # loop until low is less than equal to high
        while(low <= high):
            # check if the range is sort by comparing element at low position and element at high position
            if nums[low] <= nums[high]:
                # if it is sorted then return element at low position which is minimum
                return nums[low]
            # get the middle element
            middle = low + (high - low) // 2
            # check if the middle value is 0 or element at middle position is smaller than its previous elements 
            #     and middle value is (length-1) or element at middle position is smaller than its next elements 
            if (middle == 0 or nums[middle] < nums[middle - 1]) and (middle == length - 1 or nums[middle] < nums[middle + 1]):
                # if the condition is true then return element at low position which is minimum
                return nums[middle]
            # check if the element at low position is smaller than or equal to element at middle position then it means left part is sorted
            elif nums[low] <= nums[middle]:
                # if it is then set the low to (middle+1) ie search in right side since minimum is always on unsorted side
                low = middle + 1
            else:
                # else the right part is sorted, so set the high to (middle-1) ie search in left side since minimum is always on unsorted side
                high = middle - 1
        
        return 9999
