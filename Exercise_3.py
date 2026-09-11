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
    def findPeakElement(self, nums: List[int]) -> int:
        N = len(nums)
        if N == 0:
            return -1
        elif N == 1:
            return 0

        s = 0
        e = N-1
        while s <= e:
            mid = s + (e-s)//2

            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == N-1 or nums[mid] > nums[mid+1]):
                return mid
            else:
                if nums[mid+1] > nums[mid]:
                    s = mid + 1
                else: # nums[mid-1] > nums[mid]
                    e = mid - 1
        return 111111

def run_tests():
    tests = [ ([1,2,1,3,5,6,4], 6),
            ([1,2,3,1], 3),
            ([0,1,2,3,4,5], 5),
            ([5,4,3,2,1,0], 5),
            ([-1,2,0], 2),
            ([17,0], 17),
            ([0,17], 17),
            ([2], 2),
            ([1,2,1,0,5,6,4], 6),
    ]
    sol = Solution()
    for test in tests:
        nums, ans = test[0], test[1]
        i = sol.findPeakElement(nums)
        print(f"\nnums = {nums}")
        print(f"peak index = {i}, peak element = {nums[i]}")
        passed = (ans == nums[i])
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()