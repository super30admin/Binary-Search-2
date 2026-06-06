## Problem 3: (https://leetcode.com/problems/find-peak-element/)
# Complexity: O(log n)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        left = 0
        right = n - 1

        # binary search
        while left <= right:
            mid = left + (right - left) // 2

            # termination condition:
            # if both left and right are greater than mid, we have found a peak
            # when we check the right element(mid + 1), if mid = n - 1(last element), its always greater than its right
            # similarly, when checking left element(mid - 1), if mid = 0(first element), its always greater than its left
            if (mid == n - 1 or nums[mid] > nums[mid + 1]) and (mid == 0 or nums[mid] > nums[mid - 1]):
                return mid
            # if we didn't find peak, continue search on the side of the greater element
            elif nums[mid + 1] > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1