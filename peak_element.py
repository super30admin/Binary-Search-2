"""
TC -> O(log N)
SC -> O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1 or nums[0] > nums[1]:
            return 0

        if nums[-1] > nums[-2]:
            return len(nums) - 1

        l = 0
        h = len(nums) - 1

        while l <= h:
            mid = l + (h - l) // 2
            if nums[mid - 1] < nums[mid] and nums[mid + 1] < nums[mid]:
                # mid is the peak element
                return mid
            elif nums[mid] < nums[mid - 1]:
                # mid-1 can be a peak element
                h = mid - 1
            elif nums[mid] < nums[mid + 1]:
                # mid-1 can be a peak element
                l = mid + 1
