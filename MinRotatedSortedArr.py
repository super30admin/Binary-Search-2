# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        if len(nums) == 0:
            return -1
        
        while low <= high:
            # The array is with 0th rotation
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2 # to avoid integer overflow

            if mid != 0 and nums[mid] <= nums[mid - 1]:
                return nums[mid]

            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1


        