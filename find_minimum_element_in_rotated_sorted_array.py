# Idea: This problem is not same as find target in rotated sorted arrya, its find minimum in roatated sorted array.
# So we just think simple: first set low=0 and high = len(nums) - 1
#  then we go over a while loop to check if low <= high and then we first check if this low to high window is sorted, if its sirted then minimum will be at index low.
#  if its not sorted then we find out the mid using low + high // 2 and then we check if this is th eminimum element.
#  so what is the property of minimum element, its simple, you have to check if the mid element is smalleer than both its neighbors.
#  if it is less than both the neighbors thats th eminimum so we return else, we check if the nums[low] < nums[mid] in the range
#  Why are we doing this, think like this since its a rotated sorted arrray, when nums[low] <= nums[mid], then we are in the rotated part hence we have to go to unrotated part to find minimum,
#   so we go to the right half, or else we go to left half. and repeat the orocess, so we are basically playing with the ranges.


class Solution:
    def findMinimumElement(self, nums):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            
            
            
