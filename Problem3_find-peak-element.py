
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: 1. We start two pointers, low and high on each ends of the array and find a mid iteratively.
#          2. When we find a mid, we check if the value at mid is larger than both left and right side values, if it is we found a peak. We also check if mid is at either of the boundary and shortcircuit the logic in python to accomodate for edge cases where one of the peaks is at the edge of the array.
#          3. If we don't find a mid that satisfies the first condition, we move the pointers in such a way that guarantees a higher value than current mid in the next subarray.


class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            mid = (low + high) // 2

            if (mid == 0 or nums[mid] > nums[mid -1]) and (mid == n - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif (mid > 0 and nums[mid] < nums[mid - 1]):
                high = mid - 1
            else:
                low = mid + 1
        return -1