# Time Complexity  : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on LeetCode? : Yes
# Any problems you faced while coding this?   : Yes it was difficult to understand the logic
#                                               if ((mid == 0 or nums[mid] > nums[mid - 1]) and
#                                                  (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):

#Your code here along with comments explaining your approach in three sentences only
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1

        while low<=high:

            mid = low + (high - low)//2

            if ((mid == 0 or nums[mid] > nums[mid - 1]) and
               (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):

               return mid
            
            elif mid !=0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            else:
                low = mid + 1


