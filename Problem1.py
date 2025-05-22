"""
I implemented the solution using the technique taught in the session. I performed binary search twice: first to find the first occurrence of the target, and second to find the last occurrence of the target.
Time Complexity: O(log n)
Space Complexity: O(1)
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def first_search(nums, target):
            low = 0 
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid - 1] < nums[mid]:
                        return mid
                    else:
                        # keep moving left
                        high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
        
        def last_search(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                        return mid
                    else:
                        # keep moving right
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        first = first_search(nums, target)
        last = last_search(nums, target)
        return [first, last]