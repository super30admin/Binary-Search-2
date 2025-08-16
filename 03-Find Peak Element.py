# Problem 3 - Find Peak Element (https://leetcode.com/problems/find-peak-element/)
# Use binary search to find peak element in O(log n) time
# At each step, check if middle element is a peak; if not, move in the direction of the greater neighbor, since a peak must exist there
# This guarantees finding one peak without scanning entire array
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        if len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0

        while l <= r:
            mid = (l + r) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid == 0 or nums[mid - 1] < nums[mid]:
                l = mid + 1
            else:
                r = mid - 1