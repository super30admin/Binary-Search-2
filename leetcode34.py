#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  8 15:39:30 2026

@author: rishigoswamy
    
    Problem:
    ----------
    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    Approach:
    ----------
    Since the array is sorted in ascending order, binary search can be used
    to locate the first and last occurrences of the target efficiently.
    
    We perform two separate binary searches:
    - The first search finds the leftmost (first) position of the target by
      continuing the search on the left half even after the target is found.
    - The second search finds the rightmost (last) position of the target by
      continuing the search on the right half after the target is found.
    
    Each search carefully checks boundary conditions to ensure the correct
    extreme index is identified.
    
    Time Complexity:
    ----------------
    First binary search  : O(log n)
    Second binary search : O(log n)
    Overall              : O(log n)
    
    Space Complexity:
    -----------------
    O(1), since only constant extra space is used.
    
    Did this code successfully run on Leetcode:
    ------------------------------------------
    Yes
    
    Any problem you faced while coding this:
    ---------------------------------------
    Handling edge cases where the target appears at the beginning or end
    of the array, and ensuring both searches terminate correctly when the
    target does not exist.

"""

class Solution:
    def searchRange(self, nums, target):
        low = 0
        high = len(nums) - 1
        mid = (low + high)//2
        first, second = -1, -1

        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] != nums[mid]:
                    first = mid
                    break
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        

        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] != target:
                    second = mid
                    break
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return [first, second]