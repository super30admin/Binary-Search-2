# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if ((mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) -1 or nums[mid] < nums[mid + 1])):
                return nums[mid]
            elif nums[mid] > nums[high]:      #Imp step always check mid with high ptr, that shows where to move the ptr
                low = mid + 1
            else:
                high = mid - 1
        return -1

s = Solution()
print s.findMin([3,4,5,1,2])