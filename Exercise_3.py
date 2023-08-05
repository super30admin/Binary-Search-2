# ## Problem 3: (https://leetcode.com/problems/find-peak-element/)
# A peak element is an element that is greater than its neighbors.
# Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
# The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
# You may imagine that nums[-1] = nums[n] = -∞.
# Example 1:
# Input: nums = [1,2,3,1]
# Output: 2
# Explanation: 3 is a peak element and your function should return the index number 2.
# Example 2:
# Input: nums = [1,2,1,3,5,6,4]
# Output: 1 or 5
# Explanation: Your function can return either index number 1 where the peak element is 2,
# or index number 5 where the peak element is 6.
# Note:
# Your solution should be in logarithmic complexity.

# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def findPeakElement(self, nums):
        # creating 2 ptrs low
        low = 0
        # and high
        high = len(nums) - 1
        # binary search
        while (low <= high):
            # calculating mid
            mid = (low + high)//2
            # checking if mid is peak
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            # else shifting towards number bigger than mid
            elif (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                high = mid - 1
            else:
                low = mid + 1
        return -1


sol = Solution()
nums = [1, 2, 3, 1]
print(sol.findPeakElement(nums=nums))
