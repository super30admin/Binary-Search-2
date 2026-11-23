#Problem 1
#Using binary search method.
#T: O(log n)
#S: O(1)


class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        left = self.binarySearch(nums, target, True)
        if left == -1:
            return [-1, -1]
        right = self.binarySearch(nums, target, False)
        return [left, right]

    def binarySearch(self, nums, target, leftBias):
        l, r = 0, len(nums) - 1
        i = -1

        while l <= r:
            m = (l + r) // 2
            if nums[m] < target:
                l = m + 1

            elif nums[m] > target:
                r = m - 1

            else:
                i = m
                if leftBias:
                    r = m - 1
                else:
                    l = m + 1

        return i
