# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

# This problem demonstrates finding first and last occurence of an element in a sorted array. The input array will have elements in sorted manner, but there will be repetitions. The implementation can be done by doing 2 binary searches, one for finding first position and another to find last position. 

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:      
        left = self.binSearch(nums, target, True)
        right = self.binSearch(nums, target, False)
        return [left, right]

    def binSearch(self, nums, target, leftBias):
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] > target:
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                if leftBias:
                    if mid == low or nums[mid - 1] != nums[mid]:
                        return mid
                    else:
                        high = mid - 1
                else:
                    if mid == high or nums[mid + 1] != nums[mid]:
                        return mid
                    else:
                        low = mid + 1

        return -1