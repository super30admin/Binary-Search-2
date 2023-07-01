class Solution:
    # Time Complexity: O(log n)
    @staticmethod
    def binarySearchFirst(nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = int(low + (high - low) / 2)
            if nums[mid] == target:
                if mid == 0 or (nums[mid] > nums[mid - 1]):
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    @staticmethod
    def binarySearchLast(nums: List[int], low: int, high: int, target: int) -> int:
        while low <= high:
            mid = int(low + (high - low) / 2)
            if nums[mid] == target:
                if mid == len(nums) - 1 or (nums[mid] < nums[mid + 1]):
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        if nums[0] > target:
            return [-1, -1]
        if nums[len(nums) - 1] < target:
            return [-1, -1]
        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        last = self.binarySearchLast(nums, first, len(nums), target)
        return [first, last]
