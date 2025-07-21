# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: NO


class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0
        n = len(nums)
        low = 0
        high = len(nums) -1
        while low <= high:
            mid = (low + high) //2

            if mid > 0 and nums[mid] < nums[mid-1]:
                high = mid-1
            elif mid < n-1 and nums[mid] < nums[mid+1]:
                low = mid+1
            else:
                return mid
                
        return -1