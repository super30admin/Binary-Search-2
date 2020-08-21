# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : There's a small change in left and right bianry search while checking for nums[mid] > target


# Your code here along with comments explaining your approach 

class Solution(object):
    def leftMost(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target and (mid == 0 or nums[mid-1] != target):
                return mid
            elif nums[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def rightMost(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target and (mid == len(nums) - 1 or nums[mid+1] != target):
                return mid
            elif nums[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        left = self.leftMost(nums, target)
        if left == -1:
            return [-1,-1]
        right = self.rightMost(nums, target)
        return [left,right]

s = Solution()
print s.searchRange([5,7,7,8,8,10], 10)
