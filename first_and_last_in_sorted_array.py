class Solution(object):
    def __init__(self):
        self.firstIndex = -1

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        lo, hi = 0, len(nums) - 1

        findFirstIndex = self.binarySearch(nums, 0, hi, target)
        if findFirstIndex == -1: return [-1, -1]
        findSecondIndex = self.secondBinarySearch(nums, self.firstIndex, len(nums) - 1, target)
        return [findFirstIndex, findSecondIndex]

    def binarySearch(self, nums, lo, hi, target):
        foundIndex = -1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:

                if (mid == 0 or mid == hi or nums[mid - 1] < nums[mid]):
                    if self.firstIndex == -1: self.firstIndex = mid
                    foundIndex = mid
            if target <= nums[mid]:
                hi = mid - 1
            else:
                lo = mid + 1
        return foundIndex

    def secondBinarySearch(self, nums, lo, hi, target):
        foundIndex = -1
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if nums[mid] == target:

                if (mid == 0 or mid == hi or nums[mid] < nums[mid + 1]):
                    foundIndex = mid
            if target >= nums[mid]:
                lo = mid + 1
            else:
                hi = mid - 1

        return foundIndex


