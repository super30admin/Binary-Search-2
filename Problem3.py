# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
1. If length of array is 1, return the only element. If length of array is 2, return the index of the greater element
2. Find the middle element using binary search. If the middle element is greater than its neighbours, return the index of the middle element
3. If middle element is lesser than right element, then chances are peak is in the right half. Similarly it might be in the left half. Modify the pointers accordingly
'''
from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0 
        right = len(nums) -1
        if len(nums)==1:
            return 0
        if len(nums)==2:
            if nums[left]<nums[right]:
                return 1
            return 0
        while (left<=right):
            middle = left + (right-left)//2
            if (middle == 0 and nums[middle] > nums[middle+1]) or (middle == len(nums)-1 and nums[middle] > nums[middle-1]):
                    return middle
            if nums[middle] > nums[middle-1] and nums[middle] > nums[middle+1]:
                return middle
            if nums[middle-1] > nums[middle]:
                right = middle - 1
            elif nums[middle+1] > nums[middle] :
                left = middle + 1
        return -1
                