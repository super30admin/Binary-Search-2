# coding=utf-8
"""
162. Find peak element
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.

Time Complexity- O(log n)
Space complexity - O(1)
"""
n = [1, 2, 3, 1]


def findpeakelement(nums):
    if len(nums) == 0 or nums is None:
        return -1
    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = low + (high-low)//2  # prevent overflow

        #similar condition as used in problem2
        if (mid == low or nums[mid - 1] < nums[mid]) and (mid == high or nums[mid + 1] <= nums[mid]):
            return mid
        if mid > 0 and nums[mid] < nums[mid-1]:
            # move left
            high = mid - 1
        else:
            # move right
            low = mid + 1
    return mid

print(findpeakelement(n))


