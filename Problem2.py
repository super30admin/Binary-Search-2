# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
1. Since the array is sorted, first find the middle element using binary search. Initialize a minimum value to sys.maxsize
2. Check if middle element is smaller than the minimum value and update the minimum value if yes
3. If middle element is greater than right element, then the minimum element is in the right half. Else it is in the left half. Modify the pointers accordingly
'''

from typing import List
import sys

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0 
        right = len(nums) -1
        min_val = sys.maxsize
        while (left<=right):
            middle = left + (right-left)//2
            if nums[middle] <= min_val:
                min_val = nums[middle]
            if nums[middle] >= nums[right]:
                left = middle + 1
            else:
                right = middle - 1
        return min_val