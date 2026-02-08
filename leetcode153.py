#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  8 15:37:19 2026

@author: rishigoswamy

    Problem:
    ----------
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

    Approach:
    ----------
    The array is originally sorted in ascending order and then rotated at
    an unknown pivot, which causes the minimum element to be the rotation
    point.
    
    If the array is already sorted (nums[low] < nums[high]), the first
    element is the minimum and can be returned immediately.
    
    Otherwise, we use binary search to locate the pivot by checking the
    relationship between nums[mid] and its neighboring elements.
    If nums[mid] is smaller than nums[mid - 1], it is the minimum;
    if nums[mid + 1] is smaller than nums[mid], then nums[mid + 1] is the
    minimum.
    
    Based on whether nums[mid] lies in the left sorted portion or the right
    rotated portion, we discard one half of the search space and continue.
    
    Time Complexity:
    ----------------
    O(log n), where n is the number of elements in the array.
    
    Space Complexity:
    -----------------
    O(1), since the search is performed in-place using constant extra space.
    
    Did this code successfully run on Leetcode:
    ------------------------------------------
    Yes
    
    Any problem you faced while coding this:
    ---------------------------------------
    Carefully handling boundary conditions when accessing nums[mid - 1]
    and nums[mid + 1] to avoid index out-of-range errors.

"""


class Solution:
    def findMin(self, nums) -> int:
        low = 0
        high = len(nums) - 1

        if low == high:
            return nums[0]
        
        if nums[low] < nums[high]:
            return nums[low]

        while low <= high:
            mid = (low + high)//2

            if nums[mid] < nums[mid-1]:
                return nums[mid]
            if nums[mid+1] < nums[mid]:
                return nums[mid+1]
            
            if nums[mid] > nums[low]:
                low = mid + 1
            else:
                high = mid - 1
        
