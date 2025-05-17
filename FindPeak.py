# Explain your approach in **three sentences only** at top of your code
# 1) compute mid - check if mid is the peak by compairing element mid-1 and mid+1 
# 2) otherwise check if arry[mid-1] > mid then reject the right half and search peak in left half
# 3) otherwise search the peak in the right half idea is to move towards the element higher till peak is not found 

from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, h = 0, len(nums)-1
        while l<=h:
            mid = l + (h-l)//2
            # if mid is the peak
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid==len(nums)-1 or nums[mid+1]<nums[mid]):
                return mid
            # edge case we have to add mid!=0 otherwise in python it will compare with last element
            elif mid!=0 and nums[mid] < nums[mid-1]:
                h = mid-1
            else:
                l = mid+1
        return -1
        