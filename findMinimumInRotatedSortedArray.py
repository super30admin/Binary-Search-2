# Time Complexity: O(logn)
# Space Complexity: O(1)

# Approach:
# by looking at the problem, we can determine that the minimum element will always lie in within the unsorted portion of the array.
# First we will determine which portion of the array is sorted, and then move towards the unsorted portion, until we come across the minimum element.

from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)-1
        l, h = 0, len(nums)-1
        while l <= h:
            mid = l + (h-l)//2
            print(mid)
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==n or nums[mid]<nums[mid+1]):
                return nums[mid]
            # check if the entire range is sorted
            if nums[l] < nums[h]:
                return nums[l]
            if nums[mid] >= nums[l]:
                l = mid + 1
            else:
                h = mid - 1

# Approach 2:
# If we try to eliminate the right sorted portion first, then we will be able to handle the case where the array is already sorted without any extra steps.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)-1
        l, h = 0, len(nums)-1
        while l <= h:
            mid = l + (h-l)//2
            print(mid)
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==n or nums[mid]<nums[mid+1]):
                return nums[mid]
            if nums[mid] <= nums[h]:
                h = mid - 1
            else:
                l = mid + 1