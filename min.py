# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low=0
        high=len(nums)-1
        if(low==high):
            return nums[0]
        while(low<=high):
            if(nums[low]<=nums[high]):
                return nums[low]
            mid=low + (high-low)/2
            if((mid==0 or nums[mid]<nums[mid-1]) and (nums[mid]<nums[mid+1])):
                return nums[mid]
            elif(nums[low]<=nums[mid]):
                low=mid+1
            else:
                high=mid-1
        return 9999999
        