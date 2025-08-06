# Find minimum in a rotated sorted array
# This code uses binary search to find the minimum element in a rotated sorted array.
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l,h = 0,len(nums)-1
        while l<=h:
            mid = (l+h)//2
            if nums[l]<=nums[h]:
                return nums[l]
            elif nums[mid]<nums[mid-1] and nums[mid]<nums[mid+1]:
                return nums[mid]
            elif nums[l]<=nums[mid]:
                l = mid+1
            else:
                h = mid-1