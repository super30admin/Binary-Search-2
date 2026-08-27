#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        n = len(nums)
        while(low < high):
              mid = low + (high - low)//2
              if nums[mid] < nums[mid+1]:
                  low = mid + 1
              else:
                   high = mid
        return low 
