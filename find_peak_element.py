"""
Approach:

-> Perform binary search and check mid is greater than mid-1 and mid+1. If so, we found peak and return mid
-> if mid+1 > mid, move low pointer to mid+1 otherwise move high pointer to mid-1.

Time complexity:
O(logn)

Space complexity:
O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        low, high = 0, len(nums)-1

        while low <= high:
            mid = low + (high - low) // 2
            
            # peak element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) -1 or nums[mid] > nums[mid + 1]):
                return mid

            # make sure we are moving up (to find peak). If not, adjust pointers
            # if element next to mid is greater than mid, we are moving towards peak, so update low pointer to eliminate left half
            if nums[mid + 1] > nums[mid]:
                low = mid + 1
            
            # otherwise we are in incorrect direction, so move towars left side by updating high pointer
            else:
                high = mid - 1
        
        return -1