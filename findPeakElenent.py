# Time Complexity: O(logn)
# Space Complexity: O(1)

# Approach:
# We always try to climb towards the higher element, so we can use binary search to find the peak element.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)-1
        # initialize the high and low pointers
        l, h = 0, len(nums)-1
        # binary search
        while l <= h:
            mid = l + (h-l)//2
            # check if the mid element is greater than its neighbours, handle the cases where the mid element is at the boundary
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==n or nums[mid]>nums[mid+1]):
                return mid
            # check if the element to the right of mid is greater than mid, then move towards the right
            if nums[mid-1] <= nums[mid+1]:
                l = mid + 1
            # else move towards the left
            else:
                h = mid - 1