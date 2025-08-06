# Find peak element in an array
# This code uses binary search to find a peak element in an array
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l,h = 0, len(nums)-1
        while l<=h:
            mid =(l+h)//2
            if (mid==h or nums[mid]>nums[mid+1]) and (mid==l or nums[mid]>nums[mid-1]):
                return mid
            elif nums[mid]<nums[mid+1]:
                l = mid+1
            else:
                h = mid -1
        return -1

        