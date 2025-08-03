from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            # Minimum is in the right half
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                # Minimum is in the left half (or could be mid)
                right = mid

        return nums[left]

sol = Solution()
print(sol.findMin([3, 4, 5, 1, 2]))  
print(sol.findMin([11, 13, 15, 17]))  

# Time Complexity:
#   O(log n), where n is the number of elements in the array.
#   We perform binary search twice — once to find the first occurrence,
#   and once to find the last occurrence of the target.

# Space Complexity:
#   O(1) — only a constant number of variables are used.

# Did this code successfully run on Leetcode: Yes, 34 (Find First and Last Position of Element in Sorted Array)

# Any problem you faced while coding this:
#   Yes — I was initially confused about how to correctly identify the left and right boundaries.
#   Learned that:
#     - To find the first (leftmost) position: move right = mid - 1 when nums[mid] == target.
#     - To find the last (rightmost) position: move left = mid + 1 when nums[mid] == target.
#   This ensures binary search narrows down on the precise positions of the first and last occurrences.

