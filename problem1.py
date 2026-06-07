# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
# Time Complexity O(log(n))
# Space Complexity O(1)


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]

        def binaryFirst(nums, target, low, high):
            while low <= high:
                mid = (low + high) // 2
                if nums[mid] == target:
                    # checking first occurence
                    if mid == 0 or nums[mid - 1] != target:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def binarySecond(nums, target, low, high):
            while low <= high:
                mid = (low + high) // 2
                if nums[mid] == target:
                    # checking last occurence
                    if mid == len(nums) - 1 or nums[mid + 1] != target:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1

        first = binaryFirst(nums, target, 0, len(nums) - 1)
        last = binarySecond(nums, target, first, len(nums) - 1)
        return [first, last]
