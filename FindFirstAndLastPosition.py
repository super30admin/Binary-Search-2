# Time Complexity : O(log n) as we do binary search twice, once to determine first index and other to determine end index.
# So technically O(2log n) which boils down to O(log n)
# Space Complexity : O(1) no extra space used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if (len(nums) == 0): return [-1, -1]

        startIndex = self.firstBinarySearch(nums, target)

        if startIndex == -1:
            return [-1, -1]

        endIndex = self.secondBinarySearch(nums, target)

        return [startIndex, endIndex]

    def secondBinarySearch(self, nums, target):
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + (high - low) // 2
            if target == nums[mid]:
                if (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                    return mid
                else:
                    low = mid + 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

    def firstBinarySearch(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) // 2
            if target == nums[mid]:
                if (mid == 0 or nums[mid] > nums[mid - 1]):
                    return mid
                else:
                    high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1