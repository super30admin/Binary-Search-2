# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def find_left(nums,target):
            low = 0
            high = len(nums)-1
            while low<=high:
                mid=low+(high-low)//2
                if nums[mid]<target:
                    low = mid+1
                else:
                    high = mid-1
            return low

        def find_right(nums,target):
            low = 0
            high = len(nums)-1
            while low<=high:
                mid = low+(high-low)//2
                if nums[mid]<=target:
                    low = mid+1
                else:
                    high = mid-1
            return high
        
        first = find_left(nums,target)
        last = find_right(nums,target)
        if first <= last:
            return [first,last]
        else:
            return [-1,-1]
    
sc = Solution()
nums = [5,7,7,8,8,10]
target = 8
print(sc.searchRange(nums, target))