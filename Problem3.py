## Problem 3: (https://leetcode.com/problems/find-peak-element/)
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

#              or index number 5 where the peak element is 6.
# Note:

# Your solution should be in logarithmic complexity.

# Method 1: We choose the right half when both the neighbors are higher than mid

# Time Complexity : O(Log(base2)N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We need to find any peak. So this solution is based on slope concept. Based on where we find increasing slope we can always go
# towards the increasing slope. This would certainly give us one peak. As we are rejecting one half we can use binary search. 
# We find mid and check if it is peak and return if it is. If not peak, then we check which neighbor is higher than mid. If both
# the neighbors are higher we can choose either of them and we would reach either of the peaks 


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = int(low + (high - low) / 2)
            # check if mid is the peak
            if((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                # yes it is a peak
                return mid

            # if mid is not the peak
            # look for the higher slope
            # check if right side is greater
            # we can check if left side is greater also
            if((mid != len(nums) - 1) and nums[mid + 1] > nums[mid]):
                # preference given to right side
                # if both neighbors are greater than based on this condition
                # it will choose the right half
                # we will surely have peak on the right side
                low = mid + 1

            else:
                # left neighbor is greater
                # left half will have the peak
                high = mid - 1

        #does not matter as we will surely have a peak
        return -1
    

sol = Solution()
print("Method1: Choosen Right")
print(sol.findPeakElement([1,2,3,1]))
print(sol.findPeakElement([1,2,1,3,5,6,4]))
print(sol.findPeakElement([1,2,1,3,7,1,2]))
print(sol.findPeakElement([1]))
print(sol.findPeakElement([1, 2, 4, 3, 5, 6, 4]))


# Method 2: We choose the left half when both the neighbors are higher than mid

# Time Complexity : O(Log(base2)N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We need to find any peak. So this solution is based on slope concept. Based on where we find increasing slope we can always go
# towards the increasing slope. This would certainly give us one peak. As we are rejecting one half we can use binary search. 
# We find mid and check if it is peak and return if it is. If not peak, then we check which neighbor is higher than mid. If both
# the neighbors are higher we can choose either of them and we would reach either of the peaks 


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = int(low + (high - low) / 2)
            # check if mid is the peak
            if((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                # yes it is a peak
                return mid

            # if mid is not the peak
            # look for the higher slope
            # check if left side is greater
            # we can check if right side is greater also
            if((mid != 0) and nums[mid - 1] > nums[mid]):
                # choosen here left side
                # if both neighbors are greater than based on this condition
                # it will choose the left half
                # we will surely have peak on the left side
                high = mid - 1

            else:
                # right neighbor is greater
                # right half will have the peak
                low = mid + 1

        #does not matter as we will surely have a peak
        return -1
    

sol = Solution()
print("Method1: Choosen Left")
print(sol.findPeakElement([1,2,3,1]))
print(sol.findPeakElement([1,2,1,3,5,6,4]))
print(sol.findPeakElement([1,2,1,3,7,1,2]))
print(sol.findPeakElement([1]))
print(sol.findPeakElement([1, 2, 4, 3, 5, 6, 4]))