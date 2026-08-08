# Problem 3: (https://leetcode.com/problems/find-peak-element/)
# Time Complexity: O(log n),We cut the search range in half every step, so it takes log n steps to shrink down to one index
# Space Complexity: O(1), We only use a few variables like low, high and mid, no extra data structures
# Approach:
# Use binary search based on the slope at mid instead of sorted order
# If mid is greater than both neighbors it is already a peak, return it right away
# If the right neighbor is bigger than mid, the array is going uphill, so a peak is guaranteed on the right side, move low forward
# Otherwise the array is going downhill from mid, so a peak is guaranteed on the left side including mid, move high backward
# The edges are treated as having neighbors of negative infinity using the mid == 0 and mid == n - 1 checks

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1
        # low and high mark the current search range, start with the whole array

        while low < high:
            # keep narrowing the range until only one index is left

            mid = low + (high - low) // 2
            # pick the middle index of the current range

            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == n - 1 or nums[mid] > nums[mid + 1]):
                # check if mid is bigger than its left neighbor, treating the left edge as negative infinity and check if mid is bigger than its right neighbor, treating the right edge as negative infinity
                # if both are true, mid is a peak right now
                return mid

            elif nums[mid + 1] > nums[mid]:
                # right neighbor is bigger, so the array is going uphill here
                # a peak is guaranteed somewhere to the right, so drop the left half
                low = mid + 1

            else:
                # array is going downhill from mid, so a peak is guaranteed somewhere to the left including mid
                # drop the right half
                high = mid - 1

        return low
        # when low equals high, that single remaining index is the peak