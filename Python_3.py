"""
Time Complexity : O(log n)
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach
To find the peak element, the intuition is, calculate the mid and check if it is higher than neighbors, if yes,
we have found our peak. If no, go in the direction in which we have a higher neighbor, as that side
will definitely have a peak as that side is growing. Either it will keep on growing and reach a 
peak (ie the last element), or it will drop down from a peak. But anyhow, that side will have a peak.
"""


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid] > nums[mid-1])
            and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid+1] > nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return -1
