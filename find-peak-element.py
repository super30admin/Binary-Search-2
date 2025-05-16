"""
This implementation uses binary search to find a peak element in an array.
The array is split into two halves, and the binary search is applied to the appropriate half based on the sorted order.
The search is efficient and runs in O(log n) time.
"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        
        while left < right:
            mid = (left + right) // 2
            
            # If mid element is greater than its right neighbor,
            # then peak must be in left half (including mid)
            if nums[mid] > nums[mid + 1]:
                right = mid
            # Otherwise, peak must be in right half
            else:
                left = mid + 1
                
        return left