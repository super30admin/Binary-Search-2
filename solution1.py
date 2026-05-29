class Solution:
    def searchRange(self, nums, target):
        def binarySearchFirst(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid - 1] != target:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def binarySearchLast(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == len(nums) - 1 or nums[mid + 1] != target:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        first = binarySearchFirst(nums, target, 0, len(nums) - 1)
        if first == -1:
            return [-1, -1]
        last = binarySearchLast(nums, target, first, len(nums) - 1)
        return [first, last]
