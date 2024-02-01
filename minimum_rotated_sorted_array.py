"""
time complexity: O(log(n)) since we are using binary search 
Space complexity: O(1)
"""


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        n = len(nums)
        high = n - 1
        while low <= high:
            # Since nums is a sorted array, if hte nums(low) < = nums[high], the smallest elemetn is nums[low]
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (
                mid == n - 1 or nums[mid] < nums[mid + 1]
            ):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 124085
