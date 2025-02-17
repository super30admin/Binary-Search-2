
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]

        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] >= target:
                right = mid
            else:
                left = mid + 1
        
        if nums[left] != target:
            return [-1, -1]
        
        first = left  
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left + 1) // 2 
            if nums[mid] <= target:
                left = mid
            else:
                right = mid - 1

        last = left

        return [first, last]

