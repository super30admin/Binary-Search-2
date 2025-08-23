## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

# Your algorithm's runtime complexity must be in the order of O(log n).

# If the target is not found in the array, return [-1, -1].

# Example 1:

# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]
# Example 2:

# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]

# Time Complexity : O(Log(base2)N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Apply two separate binary search to find the left most index and right most index if target exists
# In the code we have done few optimizations of initial checks and also before running the second binary search if target exists in 
# the first place or not


class Solution(object):
    def searchRange(self, nums, target):

        def binarySearchOne(arr, low, high, target):
            while(low <= high):
                mid = int(low + (high - low) / 2)
                if(arr[mid] == target):
                    # target exists
                    # check if it is the left most index
                    if(mid == 0 or (arr[mid - 1] < target)):
                        # yes it is the left most index
                        return mid

                    high = mid - 1

                elif(arr[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1
            
            return -1

        def binarySearchSecond(arr, low, high, target):
            while(low <= high):
                mid = int(low + ((high - low) / 2))
                if(arr[mid] == target):
                    # target exists
                    # check if it is the right most index
                    if(mid == len(arr) - 1 or (arr[mid + 1] > target)):
                        # yes it is the right most index
                        return mid

                    low = mid + 1

                elif(arr[mid] > target):
                    high = mid - 1
                else:
                    low = mid + 1

            return -1
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if(not nums):
            return [-1, -1]

        if(target < nums[0] or (target > nums[len(nums) - 1])):
            return [-1, -1]

        # If we use one binary search probably we would need to search both left half(for finding the start index for the target) and right half(for finding the end index for the target). It would be O(N) as it would not reduce our search space.
        # So we can run two binary search separately. One to find the left index of the target and second to find the right index of the target

        # first binary search to find the left index
        leftIndex = binarySearchOne(nums, 0, len(nums) - 1, target)
        if(leftIndex == -1):
            # target does not exist
            return [-1, -1]

        # target exists
        # now we can do second binary search to find the right index
        # Note: we can make the low = leftIndex. This would further reduce our search space
        rightIndex = binarySearchSecond(nums, leftIndex, len(nums) - 1, target)
        return [leftIndex, rightIndex]


sol = Solution()
print(sol.searchRange([1,2,4,5,5,6,7,7,7,8,8,8,8,10], 8))
print(sol.searchRange([5,7,7,8,8,10], 8))
print(sol.searchRange([5,7,7,8,8,10], 6))
print(sol.searchRange([], 0))
print(sol.searchRange([1], 0))
print(sol.searchRange([1], 1))
print(sol.searchRange([-1,0], 0))
print(sol.searchRange([1,1], 1))