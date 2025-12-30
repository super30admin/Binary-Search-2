'''
162  Find peak element
https://leetcode.com/problems/find-peak-element/description/

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, such that where nums[i] ≠ nums[i+1], find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

Solution:
1. Using binary search, we can solve this using 3 cases.
    a) If mid is greater than neighboring elements, then mid is a peak.
    b) If there is a larger element on right (A[mid] < A[mid+1]), move right
    c) if there is a larger element on left (A[mid] < A[mid-1]), move left
    d) If there is a larger element on both sides, we can move on either side. eg. [1,2,1,0,5,6,4], mid = 3, A[mid] = 0. Now, A[mid]<1 and A[mid]<5

    Moving in the direction of smaller element may or may not result in a peak.
    But moving in the direction of larger element guarantees a peak.
    Hence, if we are not at a peak already, we always move in the direction of larger element.

    Time: O(log N), Space: O(1)
'''
from typing import List

class Solution:
    def findPeakElement(self, A: List[int]) -> int:
        N = len(A)
        if N == 0:
            return -1
        elif N == 1:
            return 0

        s = 0
        e = N-1
        while s <= e:
            mid = s + (e-s)//2

            # # edge cases: index 0 or index N -1 is a peak
            # if (mid == 0 and A[mid]>A[mid+1]) or (mid == N-1 and A[mid]> A[mid-1]):
            #     return mid

            # # peak element
            # if A[mid] > A[mid+1] and A[mid] > A[mid-1]:
            #     return mid

            # 0th index or last index of array is the peak or
            # any in-between element is the peak
            if (mid==0  or A[mid]>A[mid-1]) and (mid==N-1 or A[mid]>A[mid+1]):
                return mid

            # if larger element on right (A[mid] < A[mid+1]), move right
            # if larger element on left (A[mid] < A[mid-1]), move left
            if A[mid] < A[mid+1]:
                s = mid + 1
            elif A[mid] < A[mid-1]:
                e = mid - 1
        return -1

arrays = [ [1,2,1,3,5,6,4],
          [1,2,3,1],
          [0,1,2,3,4,5],
          [5,4,3,2,1,0],
          [-1,2,0],
          [17,0],
          [0,17],
          [2],
          [1,2,1,0,5,6,4]]
sol = Solution()
for A in arrays:
    m = sol.findPeakElement(A)
    print(f"\nA = {A}")
    print(f"peak index = {m}, peak element = {A[m]}")