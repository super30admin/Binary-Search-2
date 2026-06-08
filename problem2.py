# LEETCODE PROBLEM 153. FIND MINIMUM IN ROTATED SORTED ARRAY
# TIME COMPLEXITY: O(log N) where N is the number of elements in the array
# SPACE COMPLEXITY: O(1) 
# Any problem you faced while coding this: None

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low=0
        high=len(nums)-1
        while low<high:
            mid=(low+high)//2
            if nums[mid]<=nums[high]:
                high=mid
            else:
                low=mid+1
        return nums[low]