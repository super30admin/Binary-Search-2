# Time Complexity: O(log n)
# Space Comlexity: O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        left_idx = -1
        right_idx = -1

        # Find the left index of the target
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target and (mid == 0 or nums[mid - 1] != target):
                left_idx = mid
                break
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        # Find the right index
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target and (mid == len(nums) - 1 or nums[mid + 1] != target):
                right_idx = mid
                break
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return [left_idx, right_idx]
