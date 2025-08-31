from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0 
        r = len(nums) - 1

        while l <= r:
            mid = (l+r)//2
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif (nums[mid+1] > nums[mid]):
                l = mid + 1
            else: 
                r = mid - 1
        return -1
            

