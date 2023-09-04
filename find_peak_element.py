#  Time Complexity : O(log (n)) where n is the length of the array.
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# Since the left side and right side of the array is always -infinity, we check if item at mid is peak. Else we move towards neighbor of mid which is greater. 

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = (low + high) // 2
            if (mid ==0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            if mid == len(nums)-1 or nums[mid+1] > nums[mid]:
                low = mid + 1
            else:
                high = mid -1
        return -1
