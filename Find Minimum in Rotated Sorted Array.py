class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==None or len(nums)==0:
            return -1
        l=0
        h=len(nums)-1
        while(l<=h):
            if nums[l]<nums[h]:
                return nums[l]
            mid=(l+h)//2
            if((mid==0 or nums[mid]<nums[mid-1]) and (mid==h or nums[mid]<nums[mid+1])):
                return nums[mid]
            if nums[l]<=nums[mid]:
                l=mid+1
            else:
                h=mid-1
        return -1
