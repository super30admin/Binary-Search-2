"""
Time Complexity -> O(log N)
SC -> O(1)
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        min_element = float('inf')

        while (l <= h):
            mid = l + (h - l) // 2
            if nums[l] <= nums[mid]:
                # left sorted, minimum will be at l index
                min_element = min(min_element, nums[l])
                l = mid + 1
            else:
                # right sorted, minimum will be at mid index
                min_element = min(min_element, nums[mid])
                h = mid - 1
        return min_element
