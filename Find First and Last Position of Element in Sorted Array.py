class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def firstElement(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid] > nums[mid - 1]:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1

        def lastElement(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1

        if len(nums) == 0: return [-1, -1]
        if nums[0] > target or nums[len(nums) - 1] < target:
            return [-1, -1]
        first = firstElement(nums, target)
        if first == -1:
            return [-1, -1]
        else:
            last = lastElement(nums, target, first, len(nums) - 1)

        return [first, last]