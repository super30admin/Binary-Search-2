'''class Solution with a method searchRange, which uses two separate binary search functions (find_first and find_last) to locate the starting and ending positions of the target value. It returns the result as a list [start, end], or [-1, -1] if the target is not found in the array.
'''
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def find_first(nums, target):
            low, high = 0, len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] >= target:
                    high = mid - 1
                else:
                    low = mid + 1
            return low

        def find_last(nums, target):
            low, high = 0, len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] <= target:
                    low = mid + 1
                else:
                    high = mid - 1
            return high

        first_position = find_first(nums, target)
        last_position = find_last(nums, target)

        if first_position <= last_position:
            return [first_position, last_position]
        else:
            return [-1, -1]
