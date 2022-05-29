#Time Complexity : O(log n)
#Space Cpmplexity: 0(1)
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=0
        h=len(nums)-1
        while l<=h:
            mid=l+(h-l)/2
            if (mid==0 or nums[mid]>nums[mid-1]) and (len(nums)-1==mid or nums[mid]>nums[mid+1]):
                return mid
            elif nums[mid]<nums[mid+1]:
                l=mid+1
            else:
                h=mid-1
        return -7287