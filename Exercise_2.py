# ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
# Find the minimum element.
# You may assume no duplicate exists in the array.
# Example 1:
# Input: [3,4,5,1,2]
# Output: 1
# Example 2:
# Input: [4,5,6,7,0,1,2]
# Output: 0
# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
class Solution:
    def findMin(self, nums):
        # if just one element present
        if len(nums) == 1:
            return nums[0]
        # two ptrs low
        low = 0
        # and high
        high = len(nums) - 1
        # binary search
        while (low <= high):
            # check if sorted and rotated back to og
            if (nums[low] <= nums[high]):
                return nums[low]
            # calculate mid
            mid = (low + high)//2
            # is mid minimum
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                # return minimum
                return nums[mid]
            # reduce search by 1/2
            elif (nums[mid] >= nums[low]):
                # left sorted
                low = mid + 1
            else:
                # right sorted
                high = mid - 1
        return - 1


nums = [3, 4, 5, 1, 2]
sol = Solution()
print(sol.findMin(nums))

# S1: Read Question
# S2: Verify Constraints
# -ve allowed? []?
# S3: Test Cases :
#     [] --> -1
#     [1, ,1, 1, 1, 1, 1] --> 1
#     [1, 2, 3, 4, 5, 6] --> 1
#     [6, 1, 2, 3, 4] --> 1
# S4: Solution without code
# S5: Code with solution
# S6: check for errors
