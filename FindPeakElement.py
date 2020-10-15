#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return None

        l, r = 0, len(nums)-1

        if len(nums) < 2:
            return l if nums[l]>=nums[r] else r

        while l<r:
            mid = l + (r-l)//2
            if nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
                return mid
            elif nums[mid] < nums[mid+1]:
                l = mid + 1
            else:
                r = mid - 1

        return l
