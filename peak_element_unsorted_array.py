# Use binary search to find a peak element in O(log n) time.
# At each mid, if mid is a peak (greater than neighbors), return it.
# Otherwise, move towards the side where the neighbor is greater (guaranteed to find a peak).
from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:      
        n = len(nums)
        low, high = 0, n - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            # Check if mid is a peak element
            left_ok = (mid == 0 or nums[mid] > nums[mid - 1])
            right_ok = (mid == n - 1 or nums[mid] > nums[mid + 1])
            
            if left_ok and right_ok:
                return mid
            
            # If left neighbor is greater, move left
            if mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                # Otherwise, move right
                low = mid + 1
                
        return -1  # logically shouldn't reach here if input constraints are met
