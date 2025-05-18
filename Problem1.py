# Time Complexity  : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on LeetCode? : Yes
# Any problems you faced while coding this?   : No

#Your code here along with comments explaining your approach in three sentences only
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        low = 0
        high = len(nums) - 1
        min = -1
        max = -1
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    min = mid
                    low = min
                    high = len(nums) - 1
                    break
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        while low <= high:
            mid = low + (high - low)//2

            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                    max = mid
                    break
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return [min,max]