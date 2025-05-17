# Time Complexity : O(log n) where n = len(nums)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List

class Solution:

    def findMin(self, nums: List[int]) -> int:

        left = 0
        right = len(nums) - 1

        while left < right:
            # If array is not rotated (first <= last), the first is the minimum.
            if nums[left] < nums[right]:
                return nums[left]
            
            mid = (left + right) // 2
            
            # If mid element is greater than element at right,
            # the min must lie to the right of mid
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                # Otherwise, min is at mid or to its left
                right = mid

        return nums[left]
    
if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    nums1 = [3, 4, 5, 1, 2]
    print(sol.findMin(nums1))   # expected 1

    # Example 2
    nums2 = [4, 5, 6, 7, 0, 1, 2]
    print(sol.findMin(nums2))   # expected 0

    # Example 3
    nums3 = [11, 13, 15, 17]
    print(sol.findMin(nums3))   # expected 11

    # Additional edge: single-element
    nums4 = [42]
    print(sol.findMin(nums4))   # expected 42
            
