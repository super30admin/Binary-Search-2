# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : One of the rare question of binary search without sorted array


# Your code here along with comments explaining your approach 

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low)//2
            if ((mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1])):
                return mid
            elif nums[mid+1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1

s =  Solution()
print s.findPeakElement([1,2,3,1])