"""
This implementation uses binary search to find the minimum element in a rotated sorted array.
The array is split into two halves, and the binary search is applied to the appropriate half based on the sorted order.
The search is efficient and runs in O(log n) time.
"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        
        # If array is not rotated or has only one element
        if nums[left] <= nums[right]:
            return nums[left]
            
        while left < right:
            mid = (left + right) // 2
            
            # If mid element is greater than right element,
            # minimum must be in right half
            if nums[mid] > nums[right]:
                left = mid + 1
            # If mid element is less than right element,
            # minimum must be in left half including mid
            else:
                right = mid
                
        return nums[left]
        