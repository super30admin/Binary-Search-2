# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/


# Time Complexity : O(log(N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach in three sentences only
# Approach : This is by comparing elements at mid and high if mid is greater than high then we know that minimum is on
# the right side of the array, so low = mid + 1 else we know it is on the left side high = mid
# At the end result is at low.


from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        mid = 0
        while low < high:
            mid = low + (high - low)//2
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        return nums[low]

