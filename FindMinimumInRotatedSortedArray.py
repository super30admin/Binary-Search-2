# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: NO


class Solution:
    def findMin(self, nums: list[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            
            # check if the first element is the min value
            if nums[low] <= nums[high]:
                return nums[low]

            # check if the mid element is the min value
            if nums[mid] < nums[mid - 1] and nums[mid] < nums[mid + 1]:
                return nums[mid]

            # check if the array is left sorted or right sorted
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
            
        return 