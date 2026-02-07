# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : It uses binary search to compare each middle element with its neighbors
# and move toward the side that must contain a peak.
# If the middle element is greater than both neighbors, it returns that index as a peak.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (low == mid or nums[mid] > nums[mid - 1]) and (high == mid or nums[mid] > nums[mid + 1]):
                return mid
            elif mid == low or nums[mid] > nums[mid-1]:
                low = mid + 1
            else:
                high = mid - 1
