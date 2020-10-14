# // Time Complexity : O(log n)
# // Space Complexity : O(1) in-place
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Use binary search to find the first peak element
# The idea here is to divide the array into the following zones:
# - Ascending Zone
# - Peak
# - Descending Zone
# - Valley
# Use binary search and compare mid with neighboring elements
# Return the first peak you find!

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # Edge cases - Handle first two and last two elements
        if len(nums) == 1:
            return 0
        if nums[0] > nums[1]:
            return 0
        if nums[-1] > nums[-2]:
            return len(nums) - 1

        start = 1
        end = len(nums) - 2

        while start <= end:
            mid = start + (end - start)//2
            # Peak found, return mid
            if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return mid
            # In Ascending Zone, shift start to mid + 1
            elif nums[mid-1] < nums[mid]:
                start = mid + 1
            else:  # In Descendig Zone, move left
                end = mid - 1

        # Never reach here if peak element is guaranteed to exist
        return -1
