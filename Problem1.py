# Time Complexity: O(log n)
# Space Complexity: O(1)
# Leetcode all test cases passed: Yes
# Problems faced: Yes, not sure if changing left and right by 1 is optimal solution. Line 22-25

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums)-1
        
        while left <= right:
            
            mid = left + (right - left) // 2
            
            if nums[left] == target and nums[right] == target:
                return [left, right]
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                if nums[left] != target:
                    left += 1
                if nums[right] != target:
                    right -= 1
        return [-1,-1]
