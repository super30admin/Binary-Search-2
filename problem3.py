# https://leetcode.com/problems/find-peak-element/


# Time Complexity : O(log(N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach in three sentences only
# Approach : Here we have to find the peak, so we keep moving whichever side is having higher values from mid.
# We can find this by comparing mid with mid + 1 and if mid is greater than mid + 1 we make high as mid
# else low will be mid + 1 [as mid is not higher] then we return low index.


from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low < high:
            mid = low + (high - low) // 2

            if nums[mid] > nums[mid + 1]:
                high = mid
            else:
                low = mid + 1
        return low