class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1,-1]
        if (target < nums[0]) or (target > nums[len(nums) - 1]):
            return [-1, -1]

        def binarySearchFirst(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid - 1] != target:
                        return mid
                    else: high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
        
        def binarySearchLast(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if (mid == len(nums) - 1) or (nums[mid + 1] != target):
                        return mid
                    else : low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        first = binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        last = binarySearchLast(nums, target)
        return [first, last]
