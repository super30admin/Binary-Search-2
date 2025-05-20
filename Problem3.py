""" 
Time Complexity: O(log n)   
Space Complexity: O(1)

Approach: We know that the peak element is either greater than its neighbors or 
          it is the first or last element. So we can use binary search to find the
          peak element.
          We also know that irrespective of which side we move to, we'll always find a peak element, either way. 
          
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        N = len(nums)
        # first and last element comparision
        if len(nums) >= 2:
            if nums[0] > nums[1]:
                return 0
            elif nums[-1] > nums[N - 2]:
                return N - 1
        else:
            return 0

        # binary search on the numsay to find peak
        low = 0
        high = N - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (mid != 0 and nums[mid] > nums[mid - 1]) and (
                mid != (N - 1) and nums[mid] > nums[mid + 1]
            ):
                return mid

            if nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return -1
