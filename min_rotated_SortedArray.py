'''
Case1:
    - Complete array is sorted, return LEFT* and not 0th idx
Case 2: 
    - mid-1 < mid > mid+1 , return mid
Case 3:
    - Find the partition that is sorted, 
    minimum will always be in the non-partitioned side
# Time Complexity : 
    O(log n): Binary search 
# Space Complexity :
    O(1), just 3 pointers (left, right, mid)   
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - yes
    - Case 1 (left vs 0th index)
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1

        while left<=right:
            mid = left + (right-left)//2
            # Case 1: Sorted array
            if nums[left]<=nums[right]:
                return nums[left]
            # Case 2: 5,1,3  
            if (mid==0 or nums[mid-1]>nums[mid]) and (mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                return nums[mid]
            
            # Case 3: Identify the sorted, and move to the unsorted side
            if (nums[left]<=nums[mid]): # left sorted
                left = mid+1
            else: # right sorted
                right = mid-1

        return mid
            