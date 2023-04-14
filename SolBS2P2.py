"""
LC 34. Find First and Last Position of Element in Sorted Array
-Time Complexity : O(logN)
-Space Complexity : O(1)
-Did this code successfully run on Leetcode :
Yes
-Any problem you faced while coding this : 
Taking care of edge cases like nums = [1] or nums = [2,1]. At what time to declare that minimum is found and return the answer.

-Your code here along with comments explaining your approach
Search for min in the array using Binary search. Min element always lies in the unsorted half of the array, unless the array is sorted. (in that case, it is the first element)
1. If array is already sorted in increasing order -> return num[low]
   else calculate mid.
    If mid the min element?:   return the element
    If LHS is sorted array, min element in RHS -> Move right
    If RHS is sorted array, min element in LHS -> move left

"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]: #already sorted
                return nums[low]
            else:
                mid = low + (high-low)//2
                if  0 < mid < len(nums)-1 and nums[mid-1] > nums[mid] < nums[mid+1]:
                    return nums[mid]
                elif nums[low] <= nums[mid]:    #left half is sorted, min in RHS
                    low = mid + 1
                elif nums[mid] <= nums[high]: #RHS is sorted, min in LHS
                    high = mid - 1