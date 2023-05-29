# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We know that in a rotated sorted array, atleast one half is sorted. 
# We also know that pivot always lies in unsorted side. We use the boundaries to decide whether an array is sorted or not.
# There is a special case where both halfs are sorted, in which case the first element is the pivot and the minimum.

class Solution:
    def findMin(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return nums[0]

        l, h = 0, len(nums)-1
        while l <= h:
            # if whole array is sorted, then just return the leftmost.
            if nums[l] <= nums[h]:
                return nums[l]
            m = l + (h-l)//2
            if (m == 0 or nums[m-1]>nums[m]) and nums[m]<nums[m+1]:
                return nums[m]
            elif nums[l] <= nums[m]:
                l = m + 1
            else:
                h = m - 1
        return -1

