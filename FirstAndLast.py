# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:

    def binarySearch(self, nums, target, length):
        left = 0
        right = length-1

        while left <= right:

            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid

            elif nums[mid] < target:
                left = mid + 1

            else:
                right = mid - 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        length = len(nums)
        if length == 0:
            return [-1, -1]
        search = self.binarySearch(nums, target, length)
        if search == -1:
            return [-1, -1]

        low = search
        high = search

        while low >= 0 and nums[low] == target:
            low -= 1
        while high < length and nums[high] == target:
            high += 1

        return [low+1, high-1]
