# Time Complexity: O(log n)
# Space Complexity: O(1)
# The first pass finds the leftmost occurrence, and the second pass finds the rightmost occurrence starting from the leftmost index. 

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        if not nums:
            return [-1, -1]
        
        left_most = self.get_left_most(nums, target)
        if left_most == len(nums) or nums[left_most] != target:
            return [-1, -1]
        
        right_most = self.get_right_most(nums, target, left_most)
        return [left_most, right_most]

    def get_left_most(self, nums: list[int], target: int) -> int:
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] >= target:
                end = mid - 1
            else:
                start = mid + 1
        return start

    def get_right_most(self, nums: list[int], target: int, left_most: int) -> int:
        start, end = left_most, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] <= target:
                start = mid + 1
            else:
                end = mid - 1
        return end
