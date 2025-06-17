# Time Complexity - O(log n)
# Space Complexity - O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findLeft():
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left

        def findRight():
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] <= target:
                    left = mid + 1
                else:
                    right = mid - 1
            return right

        left_idx = findLeft()
        right_idx = findRight()

        # Check if the target is present
        if left_idx <= right_idx:
            return [left_idx, right_idx]
        else:
            return [-1, -1]