#Time complexity : O(logn)
#Space complexity : O(1)

import math
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        if(n==1):
            return nums[0]
        
        low = 0
        high = n-1
        if(nums[low]<nums[high]):
            return nums[low]
        while(low<=high):
            mid = low + (high-low)//2
            if(nums[mid]>nums[mid+1]):
                return nums[mid+1]
            if(nums[mid-1]>nums[mid]):
                return nums[mid]
            if(nums[mid]>nums[low]):
                low = mid+1
            else:
                high = mid-1

