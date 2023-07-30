#Time Complexity=O(logn)
#Space Complexity =o(1)
# Did this code successfully run on Leetcode : yes 

from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
          # If the list has just one element then return that element.
        if len(nums)==1:
            return nums[0]
        low=0
        high=len(nums)-1
        if nums[high]>nums[0]:
            return nums[0]
        # Binary Search
        while low<=high:
            mid=low+(high-low)//2
             # This point would be the point of change. From higher to lower value.
            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
             # if the mid element is lesser than its previous element then mid element is the smallest
            if nums[mid-1]>nums[mid]:
                return nums[mid]
             # if the mid elements value is greater than the 0th element this means
            # the least value is still somewhere to the right as we are still dealing with elements greater than nums[0]
            if nums[mid]>nums[0]:
                low=mid+1
            else:
                high=mid+1