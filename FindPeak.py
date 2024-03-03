# TC = O(logn)
# SC = O(1)
class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (
                mid == high or nums[mid + 1] < nums[mid]
            ):
                return mid
            elif mid != high and nums[mid + 1] > nums[mid]:
                low = mid + 1

            else:
                high = mid - 1
