# -*- coding: utf-8 -*-
"""PeakElement.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1kKe4KurPDXmXM8fke6Pr6tz0yC9ksla5
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if (nums == None):
            return -1
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) // 2
            if (((mid == low) or (nums[mid] > nums[mid-1])) and ((mid == high) or (nums[mid] > nums[mid+1]))):
                return mid
            elif (nums[mid+1] > nums[mid]):
                low = mid +1
            else:
                high = mid -1
        return 333333