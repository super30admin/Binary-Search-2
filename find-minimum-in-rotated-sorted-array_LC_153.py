#TC:O(log n) SC:O(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return -1

        L=0 
        R=len(nums)-1
 
        while L<=R:
            mid=(L+R)/2 #0
            if nums[L]<=nums[R] :
                return nums[L]
            elif (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[L]<=nums[mid]:
                L=mid+1  
            else: 
                R=mid-1
        return -1      
