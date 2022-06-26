# Time Complexity = O(logn)
# Space Complexity = O(1)

class Solution:
    def findMin(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            # If the array is already sorted
            if nums[low] <= nums[high]:
                return nums[low]
            
            mid = low + ((high - low) // 2)
            
            # Checking if mid is the minima
            if (mid == 0 or nums[mid] < nums[mid + 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid - 1]):
                return nums[mid]
            # Deciding the direction of traversal along array
            elif nums[low] <= nums[mid]:        # Left array is sorted, move rightwards
                low = mid + 1
            else:                               # Right array is sorted, move leftwards
                high = mid - 1