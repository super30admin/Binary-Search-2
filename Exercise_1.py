# # ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
# Your algorithm's runtime complexity must be in the order of O(log n).
# If the target is not found in the array, return [-1, -1].
# Example 1:
# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]
# Example 2:
# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]

# // Time Complexity : O(logn + logn) = O(2logn) = O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def searchRange(self, nums, target):
        # if array empty return [-1, -1]
        if len(nums) == 0:
            return [-1, -1]
        # if array wiith one element and matches target
        if len(nums) == 1 and nums[0] == target:
            return [0, 0]
        # binary search for first index
        first_index = self.binary_search_first(nums, target)
        # if first_index is not found then not present
        if first_index == -1:
            return [-1, -1]
        # finding right boundary
        last_index = self.binary_search_last(nums, first_index)
        return [first_index, last_index]

    def binary_search_first(self, nums, target):
        # else getting two ptrs low
        low = 0
        # and high
        high = len(nums) - 1
        # binary search left boundary
        while (low <= high):
            # calculating mid
            mid = (low + high)//2
            # if mid has target
            if nums[mid] == target:
                # checking if it is the left boundary
                if (mid == 0 or nums[mid] > nums[mid - 1]):
                    return mid
                else:
                    # else reducing search by 1/2
                    high = mid - 1
            # reducing search by 1/2 till target is found
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return - 1

    def binary_search_last(self, nums, low):
        target = nums[low]
        high = len(nums) - 1
        # binary search right boundary
        while (low <= high):
            # calculating mid
            mid = (low + high)//2
            # if mid has target
            if nums[mid] == target:
                # checking if it is the left boundary
                if (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                    return mid
                else:
                    # else reducing search by 1/2
                    low = mid + 1
            # reducing search by 1/2 till target is found
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return - 1


nums = [5, 7, 7, 8, 8, 10]
target = 8
sol = Solution()
print(sol.searchRange(nums, target))
# S1: Read Question
# S2: verify constraints --> duplicates?
# S3: Test Cases -->
#     [1, 2, 2, 2, 3, 4, 4, 4, 4,5 ,6, 7] target --> 4 -->[5, 8]
#     [1, 2, 2, 2, 3, 4, 4, 4, 4,5 ,6, 7] target --> 16 -->[-1, -1]
# [] --> [-1, -1]
# [1] --> [] ?
# S4: Solution without code
# S5: Code solution
