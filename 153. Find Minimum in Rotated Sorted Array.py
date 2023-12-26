# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(logn)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Edge cases


class Solution:
    '''
    - Considering half of rotated array is always sorted
    - the minimum element will always lie on unsorted part
    - using binary search technique ro eleminate sorted part in each iteration.
    '''
    def findMin(self, nums: List[int]) -> int:
        size = len(nums)
        low = 0
        high = size - 1
        
        while(low <= high):
            if nums[low] < nums[high]: # when all array is sorted
                return nums[low]
            mid = low + (high - low)//2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == size -1 or nums[mid] < nums[mid + 1]): # when min element is found 
                return nums[mid]
            elif (nums[mid] < nums[low]): # this means left part is unsorted
                high = mid - 1
            else:
                low = mid + 1
        return -1