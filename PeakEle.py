from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if nums[mid] > nums[mid + 1]:
                right = mid  # peak is on the left side (including mid)
            else:
                left = mid + 1  # peak is on the right side (excluding mid)

        return left  # or right, both are same now

sol = Solution()
print(sol.findPeakElement([1, 2, 3, 1]))  
print(sol.findPeakElement([1, 2, 1, 3, 5, 6, 4]))  

# Time Complexity:
#   O(log n), because we halve the search space each time using binary search.

# Space Complexity:
#   O(1), since we use only constant space (left, right, mid pointers).

# Did this code successfully run on Leetcode: Yes, 162 (Find Peak Element)

# Any problem you faced while coding this:
#   Yes — understanding that we don’t need to check both sides at once.
#   Learned that if nums[mid] > nums[mid + 1], the peak is on the left;
#   otherwise, it's on the right. Binary search guarantees at least one peak.
