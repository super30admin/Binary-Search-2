#Time Complexity: O(logn)
#Space Complexity: O(1)
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==1 or nums[0]>nums[1]:
            return 0
        elif nums[len(nums)-1]>nums[len(nums)-2]:
            return len(nums)-1
        l=0
        h=len(nums)-1
        while(l<=h):
            mid=(l+h)//2
            if nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1]:
                return mid
            elif nums[mid]>nums[mid+1]:
                h=mid-1
            else:
                l=mid+1
            