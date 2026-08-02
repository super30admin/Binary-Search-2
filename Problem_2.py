# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

# Time complexity: O(log n)
# Space complexity: O(1)
# Explanation: To find the mininum we need to find the pivot element where the array is rotated to.
# Perform a binary search with the condition of finding this change - either you are in the sorted part of the array, or you have reached the pivot element.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
        
            mid = low + (high - low) // 2
            
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
