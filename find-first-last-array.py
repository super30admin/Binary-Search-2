"""
This solution uses two binary searches to find the first and last occurrences of target in O(log n) time. 
The first binary search continues left when target is found to get the earliest occurrence, while the second search continues right to get the latest occurrence. 
If target is not found, both searches return -1, resulting in [-1, -1].
"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def find_first(nums: List[int], target: int) -> int:
            left, right = 0, len(nums) - 1
            first_pos = -1
            
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    first_pos = mid
                    right = mid - 1  # Look for target in left half
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return first_pos
        
        def find_last(nums: List[int], target: int) -> int:
            left, right = 0, len(nums) - 1
            last_pos = -1
            
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    last_pos = mid
                    left = mid + 1  # Look for target in right half
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return last_pos
        
        first = find_first(nums, target)
        last = find_last(nums, target)
        return [first, last]