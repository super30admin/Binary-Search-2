# Problem-3:  162. Find Peak Element
# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  #34
# Any problem you faced while coding this : No

# Approach
# Find mid and compare it with the neighbor element and move toward the element of greater side until you find peak.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = low + (high-low)//2
            if (mid == high or nums[mid] > nums[mid+1]) and (mid == 0 or nums[mid] > nums[mid-1]):
                return mid
            elif nums[mid+1] > nums[mid]:
                low = mid+1
            else:
                high = mid -1
        return -1