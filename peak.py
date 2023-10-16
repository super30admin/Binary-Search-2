# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# do the binary search in the input list to see if that element is the peak or not. if not move towards the side with bigger element
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        low, high = 0, n-1
        if(n==2):
            if(nums[0]>nums[1]):
                return 0
            else:
                return 1
        elif(n==1 or n==0):
            return 0
        while(low<=high):
            mid=low+(high-low)/2
            if((mid==n-1 or nums[mid]> nums[mid+1]) and (mid==0 or nums[mid]>nums[mid-1])):
                return mid
            elif(nums[mid-1]>=nums[mid+1]):
                high=mid-1
            else:
                low=mid+1
        