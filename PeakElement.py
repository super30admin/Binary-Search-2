#Time Complexity :O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#Approach: if mid is not the peak move the pointers to the side that is increasing when compared with mid

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        n = len(nums)
        high = n - 1
        while low <= high:
            mid = high + (low - high) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == n - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid + 1]: ## move the pointer to the increasing side to get the peak
                low = mid + 1
            else:
                high = mid - 1
        return -1

        
