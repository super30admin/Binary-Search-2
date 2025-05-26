# Time Complexity: O(log N)
# Two Binary searches so O(log N) + o(log N) = O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# We are performing two separate binary searches here. starting_position to find the first occurence of the target
# ending_position to find the last occurence of the target
# if target is not found in both return -1


from typing import List
class Solution:
    def starting_position(self, nums, target, low, high):
        while(low <= high):
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if low == mid or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def ending_position(self, nums, target, low, high):
        while(low <= high):
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if mid == high or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    def searchRange(self, nums: List[int], target: int):
        start_position = self.starting_position(nums, target, 0, len(nums)-1)
        end_position = self.ending_position(nums, target, 0, len(nums)-1)
        return [start_position, end_position]