# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took time to come up with left and right index approach

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        left, right = 0, len(nums) - 1
        retList = []
        
        # get the first left index
        # whenever the target is <= nums[mid] I'm going to the left side by changing right to mid - 1
        while left <= right:
            mid = left + (right - left) // 2
            if target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        retList.append(left)
        
        left, right = 0, len(nums) - 1
        # get the last right index
        while left <= right:
            mid = left + (right - left) // 2
            if target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        retList.append(right)
        
        right, left = retList.pop(), retList.pop()
        if left > right:
            left, right = -1, -1
        return [left, right]

obj = Solution()

nums = [5,7,7,8,8,10]
target = 8
output = [3,4]
print(obj.searchRange(nums, target) == output)

nums = [5,7,7,8,8,10]
target = 6
output = [-1,-1]
print(obj.searchRange(nums,target) == output)