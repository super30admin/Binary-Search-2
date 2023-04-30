"""
LC 162. Find Peak Element
    -Time Complexity : O(logN)
    -Space Complexity : O(1)
    -Did this code successfully run on Leetcode : Yes
    -Any problem you faced while coding this :  Only after the class, I got to know this fact that - BS can be done on a non sorted array!!
    -Your code here along with comments explaining your approach.
    1. Use BS.
    2. Move to side from mid where you find a higher element because that could be a potential peak. 
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid] < nums[mid+1]:
                low = mid + 1
            elif nums[mid-1] > nums[mid]:
                high = mid - 1
        return -1