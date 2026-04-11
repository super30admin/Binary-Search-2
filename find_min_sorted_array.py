# // Time Complexity :  O(log n)
# // Space Complexity :  O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Thinking of edge cases took attempts

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums)-1

        while(low <= high):            
            if nums[low] <= nums[high]: 
                return nums[low]

            mid = low+ (high-low)//2

            if nums[mid-1] > nums[mid] : return nums[mid]
            if nums[low] <= nums[mid] : low = mid+1
            else: high = mid-1