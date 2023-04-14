"""
LC 34. Find First and Last Position of Element in Sorted Array
-Time Complexity : O(logN)
-Space Complexity : O(1)
-Did this code successfully run on Leetcode :
Yes
-Any problem you faced while coding this : 
When I was doing this before class, I was thinking it to be a recursive problem. 

-Your code here along with comments explaining your approach
1. Search for element in the array using Binary search. 
    Is found?:
        YES
            - if it is the leftmost element? 
                If yes, return the index. 
                If no, move left.
        NO
            - return -1
2. find the rightmost element
    Search for element in the array using Binary search. 
        Is found?:
            YES
                - if it is the rightmost element?  nums[mid] != nums[mid+1]
                    If yes, return the index. 
                    If no, move right.  low = mid + 1
            NO
                - return -1
3. return the [leftmost Index, rightmost Index]
    
"""

class Solution:
    def binarySearchLeft(self, low, high, target, nums):
        low = 0
        high =len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def binarySearchRight(self, low, high, target, nums):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] != nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def searchRange(self, nums: List[int], target: int):
        low = 0
        high = len(nums)-1
        leftPos = self.binarySearchLeft(low, high, target, nums)
        if leftPos == -1:
            return [-1,-1]
        rightPos = self.binarySearchRight(low, high, target, nums)
        return [leftPos, rightPos]