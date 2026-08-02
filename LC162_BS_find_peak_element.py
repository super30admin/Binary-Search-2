#  Time Complexity : O(log n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach:Compare nums[mid] with nums[mid + 1]: if the next element is larger, search the right half
# otherwise, search the left half (including mid) until you find a peak.


class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low < high:
            mid = (low + high) // 2
            if nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid
        return low
