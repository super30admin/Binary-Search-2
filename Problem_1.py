# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

# Time complexity: O(log n)
# Space complexity: O(1)
# Explanation: Perform two binary searches - one to find the first position, and another to find the second position.
# If the first binary search returns no index, that mean that target doesn't exist in the nums array.


class Solution:
    def firstBinarySearch(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != target:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def lastBinarySearch(self, nums: List[int], target, low, high) -> int:
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] != target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = self.firstBinarySearch(nums, target)
        if first == -1:
            return [-1, -1]
        last = self.lastBinarySearch(nums, target, first, len(nums) - 1)
        return [first, last]        