'''
Time complexity: O(log N)
Space complexity: O(1)
'''
from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
       if len(nums) == 1:
        return nums[0]
       
       low = 0
       high = len(nums) - 1
       while low<=high:
        #checking if the array is completely sorted
        if nums[low] <= nums[high]:
            return nums[low]
        
        mid = low + (high - low)//2
        # check if the mid element is the minimum
        if (mid ==0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid]<nums[mid + 1]):
            return nums[mid]
        # checking if left side is sorted
        if nums[low]<=nums[mid]: #i'm using <= because the mid and low can be at the same idx
            low = mid + 1 
        else:
            high = mid - 1
        

        
