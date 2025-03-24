"""
#Approach:
We are using binary search to find the first and last occurance of an element in a sorted array.  
Here we are performing 2 binary sorts. one to find the first occurance and other to find the last occurance.
We initialize both occurances as -1 and check if mid is equal to target.
If mid matches the target, then for first occurance, we move the end to mid -1 and for last occurance we move mid to m + 1
For remaining 2 cases nums[mid] > target and nums[mid] < target, based on the result we change the start and end point.
# Complexity
- Time complexity:
O(logn)

- Space complexity:
O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

from typing import List

class Solution:
    def searchRange(self, nums:List[int], target: int) -> List[int]:
        return [self.findFirstOccurance(nums, target), self.findLastOccurance(nums, target)]
    
    def findFirstOccurance(self, nums:List[int], target: int) -> int:
        start, end = 0, len(nums) - 1
        first = -1
        while(start <= end):
            mid = start + (end - start)//2
            if nums[mid] == target:
                first = mid
                end = mid -1
            elif nums[mid] > target:  # first occurance must be in the left half (including mid)
                end = mid -1
            else: # peak must be in the right half
                start = mid + 1
        return first


    def findLastOccurance(self, nums:List[int], target: int) -> int:
        start, end = 0, len(nums) - 1
        last = -1
        while(start <= end):
            mid = start + (end - start)//2
            if nums[mid] == target:
                last = mid
                start = mid + 1
            elif nums[mid] > target:  # last occurance must be in the left half (including mid)
                end = mid -1
            else: # peak must be in the right half
                start = mid + 1
        return last


nums = [5,7,7,8,8,10]
target = 8
nums1 = [5,7,7,8,8,10]
target1 = 6
sol = Solution()
print(sol.searchRange(nums, target))
print(sol.searchRange(nums1, target1))