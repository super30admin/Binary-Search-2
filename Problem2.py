# Time Complexity  : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on LeetCode? : Yes
# Any problems you faced while coding this?   : It was pretty easy

#Your code here along with comments explaining your approach in three sentences only
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low)//2
            if nums[mid] >= nums[low]:
                low = mid + 1
            else:
                high = mid
        


            

