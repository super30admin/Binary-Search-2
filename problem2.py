# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
# Time Complexity O(log(n))
# Space Complexity O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            if mid > 0 and nums[mid] < nums[mid - 1]:
                # mid>0 is a condition that if mid[0] the condition would fail
                return nums[mid]
            elif nums[low] <= nums[mid]:
                # left sorted
                low = mid + 1
            else:
                high = mid - 1
        return -1
