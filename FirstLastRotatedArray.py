# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : It performs two modified binary searches: one to find the first occurrence and one to find the last occurrence of the target.
# Each search narrows the range by checking neighbors when a match is found, ensuring the correct boundary index is returned.

class Solution:
    def binarySearchFirst(self, nums: List[int], target: int, low: int, high: int) -> int:
        while low <= high:
            mid = low + ((high - low) // 2)

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

    def binarySearchLast(self, nums: List[int], target: int, low: int, high: int) -> int:
        while low <= high:
            mid = low + ((high - low) // 2)

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

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or target < nums[0] or target > nums[len(nums)-1]:
            return [-1, -1]

        first = self.binarySearchFirst(nums, target, 0, len(nums) - 1)

        if first == -1:
            return [-1, -1]

        last = self.binarySearchLast(nums, target, first, len(nums) - 1)

        return [first, last]