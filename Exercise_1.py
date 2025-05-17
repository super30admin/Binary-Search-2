# time complexity - O(log(n))
# space complexity - O(1)
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums or target < nums[0] or target > nums[-1]:
            return [-1, -1]

        firstIdx = self.binarySearchFirst(nums, 0, len(nums) - 1, target)
        if firstIdx == -1:
            return [-1, -1]

        lastIdx = self.binarySearchLast(nums, firstIdx, len(nums) - 1, target)
        return [firstIdx, lastIdx]

    def binarySearchFirst(self, nums, low, high, target):
        result = -1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                result = mid
                high = mid - 1  # keep searching to the left
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return result

    def binarySearchLast(self, nums, low, high, target):
        result = -1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                result = mid
                low = mid + 1  # keep searching to the right
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return result


             