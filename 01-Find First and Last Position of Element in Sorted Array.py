# Problem 1 - Find First and Last Position of Element in Sorted Array (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
# Use two binary searches to find first and last positions of target in a sorted array
# First binary search moves left when duplicates are found, ensuring we capture earliest index of target
# Second binary search moves right when duplicates are found, ensuring we capture latest index, both in O(log n) time
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1,-1]
        first = self.binarySearchfirst(nums, target)
        if first == -1:
            return [-1,-1]
        last = self.binarySearchlast(nums, target, first)
        return [first,last]
    
    def binarySearchfirst(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                if (mid == 0) or (nums[mid] != nums[mid - 1]):
                    return mid
                else:
                    r = mid - 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1
    
    def binarySearchlast(self, nums: List[int], target: int, first: int) -> int:
        l, r = first, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                if (mid == len(nums) - 1) or (nums[mid] != nums[mid + 1]):
                    return mid
                else:
                    l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1