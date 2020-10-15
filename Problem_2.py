
"""
Time Complexity : O(log n)
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach
For this question, we do our normal binary search, we check if the array is already sorted, then low is returned
as minimum. Then we find the mid, if low<mid, that means minimum is in the other part and vice versa. 
Also, at every mid, we check if it is lower than its neighbors, if yes, it is the minimum
and we return it
"""


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None
        low = 0
        high = len(nums)-1
        while low <= high:
            if nums[high] > nums[low]:
                return nums[low]
            mid = low + (high-low)//2
            if ((mid == len(nums)-1) or (nums[mid] < nums[mid+1])) and ((mid == 0) or (nums[mid] < nums[mid-1])):
                return nums[mid]
            if nums[mid] >= nums[low]:
                low = mid+1
            else:
                high = mid-1
