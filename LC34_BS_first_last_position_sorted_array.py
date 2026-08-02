#  Time Complexity : O(log n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : yes
#  Any problem you faced while coding this : No

# Approach: two binary searches to find the first and last positions of the target in a sorted array.


class Solution:
    def firstBinarySearch(self, nums: list[int], low: int, high: int, target: int):
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == low or nums[mid] != nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def lastBinarySearch(self, nums: list[int], low: int, high: int, target: int):
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == high or nums[mid] != nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: list[int], target: int) -> list[int]:
        low = 0
        high = len(nums) - 1
        first = self.firstBinarySearch(nums, low, high, target)
        if first == -1:
            return [-1, -1]
        second = self.lastBinarySearch(nums, first, high, target)

        return [first, second]
