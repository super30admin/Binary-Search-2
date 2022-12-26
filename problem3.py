class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left_idx = -1
        right_idx = -1
        for i in range(len(nums)):
            if nums[i] == target:
                left_idx = i
                break

        for j in range(len(nums)-1, -1, -1):
            if nums[j] == target:
                right_idx = j
                break
        return [left_idx, right_idx]