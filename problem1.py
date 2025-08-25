# Time Complexity : O(log n)  # because we perform two binary searches
# Space Complexity : O(1)    # only a few variables are used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding how to stop at the first and last occurrence

# Your code here along with comments explaining your approach in three sentences only:
# I used binary search twice: once to find the first occurrence of the target and once to find the last.
# In the first search, I move left when I find the target to ensure it's the first position, and in the second, I move right for the last position.
# If the target is not found, I return [-1, -1], otherwise I return [first, last].
class Solution:
    def searchRange(self, nums, target):
        # Helper function to find the first position of target
        def binarySearchFirst(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    # if at start of array OR previous element is not target
                    if mid == 0 or nums[mid - 1] != target:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1 # target is smaller → search left
                else:
                    low = mid + 1 # target is larger → search right
            return -1

        # Helper function to find the last position of target
        def binarySearchLast(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    # if at end of array OR next element is not target
                    if mid == len(nums) - 1 or nums[mid + 1] != target:
                        return mid
                    else:
                        low = mid + 1 # keep looking on the right side
                elif nums[mid] > target:
                    high = mid - 1 # target is smaller → search left
                else:
                    low = mid + 1 # target is larger → search right
            return -1

        # Step 1: find the first occurrence
        first = binarySearchFirst(nums, target, 0, len(nums) - 1)
        if first == -1:
            return [-1, -1]
        # Step 2: find the last occurrence
        last = binarySearchLast(nums, target, first, len(nums) - 1)
        return [first, last]
