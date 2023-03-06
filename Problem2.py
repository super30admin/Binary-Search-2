# TC-> O(logn)
# SC -> O(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left= 0
        right= len(nums)-1
        
        if len(nums)==1:
            return nums[0]
        if nums[left]< nums[right]:
            # Already Sorted Case.
            return nums[left]
        
        while left<right:
            mid= (left+right)//2

            # [3,4,5,1,2]
            if nums[mid]>nums[mid+1]:
                # minimum after mid
                return nums[mid+1]
            elif nums[mid]<nums[mid-1]:
                # minimum before mid
                return nums[mid]
            if nums[mid]> nums[right]:
                # reject left sub array
                left= mid+1
            elif nums[mid]< nums[left]:
                # reject right sub array
                right= mid-1
            