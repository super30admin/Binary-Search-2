
"""
Time Complexity : O(log n)
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach
As this array is sorted and pivoted at a point, we will divide the array in 2 parts, if mid is greater than 
the mid[low], that means minimum is not in that part, so we do low=mid+1 and if mid is less than high, that
means minimum is not in that subarray, so we do high=mid-1
Also, at every mid point we check its left and right value. If right value is low, that is the 
minimum, if left is higher than mid, mid is the minimum.
"""


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        if len(nums) == 1:
            return nums[0]
        low = 0
        high = len(nums)-1
        if nums[high] > nums[low]:
            return nums[0]
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            elif nums[mid] < nums[mid-1]:
                return nums[mid]
            if nums[mid] > nums[low]:
                low = mid+1
            else:
                high = mid-1
