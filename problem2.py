# Time Complexity : O(log n)   # binary search halves the search space each step
# Space Complexity : O(1)      # only a few pointers (l, r, mid) are used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Handling edge cases at the array boundaries (mid = 0 or mid = n-1)

# Your code here along with comments explaining your approach in three sentences only:
# I used a binary search to find the minimum element in a rotated sorted array.
# If the current subarray is already sorted, the leftmost element is the minimum; otherwise I check if mid is the pivot (smaller than neighbors).
# Depending on which half is sorted, I move the search boundaries accordingly until I find the minimum.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l <= r:
            # if the subarray nums[l..r] is already sorted, the leftmost element is the minimum
            if nums[l] < nums[r]:
                return nums[l]

            mid = (l + r) // 2
            # check if nums[mid] is the pivot (smaller than both neighbors)
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            # if left half is sorted, min must be in the right half
            elif nums[l] <= nums[mid]:
                l = mid + 1
            # otherwise, the min is in the left half
            else:
                r = mid - 1

        return

