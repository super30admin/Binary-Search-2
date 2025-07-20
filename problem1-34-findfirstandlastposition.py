#Time Complexity : log2n + log2n = logn
#Space Complexity 0(1)
#here we want to find first element and we will check mid if mid is equal to target then we will check if one element left to it is equal to target then do binary search on left side and find first occurance
# then if we have not find target then return -1
# if then again we will do the same search right side of element
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1, -1]
        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        last = self.binarySearchLast(nums, target)
        return [first, last]

    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if (mid == 0 or nums[mid] != nums[mid - 1]):
                    return mid
                else:
                    # keep on moving towards left
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if (mid == high or nums[mid] != nums[mid + 1]):
                    return mid
                else:
                    # keep on moving towards left
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1





