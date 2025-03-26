# Time Complexity : O(log2 n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
     low = 0
     n = len(nums)
     high = n-1
     while(low <= high):
        mid = low + (high - low)//2
        if((mid == 0 or nums[mid]>nums[mid-1]) and (mid == n-1 or nums[mid]>nums[mid+1])):
            return mid
        elif(mid > 0 and nums[mid] < nums[mid-1]):
            high = mid - 1
        else:
            low = mid + 1

     return -1