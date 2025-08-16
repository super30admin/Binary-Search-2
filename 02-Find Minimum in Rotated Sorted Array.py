# Problem 2 - Find Minimum in Rotated Sorted Array (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Use binary search to find minimum in rotated sorted array by narrowing down search range based on sorted side
# If current subarray is already sorted, leftmost element is minimum
# Otherwise, we check if middle element is pivot (smaller than both neighbors), or move left/right depending on which half is unsorted
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        if len(nums) == 0:
            return -1
        
        if len(nums) == 1:
            return nums[0]

        while l <= r:
            mid = (l + r) // 2
            if nums[l] <= nums[r]:
                return nums[l]
            if nums[mid] < nums[mid - 1] and nums[mid] < nums[mid + 1]:
                return nums[mid]
            elif nums[l] <= nums[mid]:
                l = mid + 1
            else:
                r = mid - 1