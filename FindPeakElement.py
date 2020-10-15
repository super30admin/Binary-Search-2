#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        while l<r:
            mid = l + (r-l)//2
            print(nums[mid], nums[mid+1], nums[mid-1], mid, l, r)
            if nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
                return mid
            elif nums[mid] < nums[mid+1]:
                l = mid + 1
            else:
                r = mid - 1

        return l
