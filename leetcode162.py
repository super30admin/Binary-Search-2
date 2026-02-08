#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb  8 15:43:49 2026

@author: rishigoswamy

    Problem:
    ----------
    https://leetcode.com/problems/find-peak-element/
    
    Approach:
    ----------
    A peak element is defined as an element that is strictly greater than
    its neighboring elements, and the problem guarantees that a peak
    always exists.
    
    We use binary search to efficiently find a peak by comparing the
    middle element with its neighbors.
    If the middle element is greater than both neighbors, it is a peak
    and can be returned immediately.
    
    If the left neighbor is greater than the middle element, a peak must
    exist in the left half of the array; otherwise, a peak must exist in
    the right half.
    By discarding half of the search space at each step, we maintain
    logarithmic time complexity.
    
    Special boundary checks are performed for the first and last elements
    to safely handle edge cases.
    
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
    Handling boundary conditions for the first and last indices and
    correctly deciding which half of the array to discard during the
    binary search.


"""
import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        if high == low:
            return 0

        while low <= high:
            
            mid = (low+high)//2

            if mid == 0 and nums[mid+1] < nums[mid]:
                return mid
            
            elif mid == len(nums) - 1 and nums[mid-1] < nums[mid]:
                return mid
            
            elif nums[mid-1] < nums[mid] and nums[mid+1] < nums[mid]:
                return mid

            if mid > 0 and nums[mid] < nums[mid-1]:
                high = mid - 1
            
            elif mid < len(nums):
                low = mid + 1
        

