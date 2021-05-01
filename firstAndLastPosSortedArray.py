"""
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Method 1: Iterate from starting of index to get first occurrence of target. Iterate from end to get index of last
occurrence of target --> O(n) + O(n)
Method 2: Iterate through array to check if target is present and store the index of its first occurrence. Update index
for each subsequence occurrence till end of array is reached --> O(n).
Method 3: Keep one pointer at the start. Keep other pointer at the end. Iterate together. Starting pointer will move
forward and ending pointer will move backward. Keep on checking if starting pointer or ending pointer index value is
equal to target. If first pointer finds the target, stop it and continue iterating the end pointer and vice-versa.
Continue iteration till indexes are found or first pointer < end pointer --> O(n).
Method 4: Perform binary search to find the target. Then keep two pointers at the target and move them left and right to
get the first and last occurrence of target --> Log(n) + ~O(n)
Method 5: Perform binary search to find the target. Perform binary search on LHS and RHS i.e. parallel binary search. It
looks O(2logn) but it breaks the rule of binary search to always reduce the search sub-space by half and actually is
linear runtime complexity for worst case.
Method 6: Find the first occurrence of the target element in the whole array using binary search and by checking if the
mid > left index in the sub-array. Find the last occurrence of the target element in the whole array using binary search
by checking if mid < right index in the sub-array.
Edge cases:
1. Check if mid are the first or last elements to avoid array out of bounds exception while moving left or right.
2. If target is not found in first binary search, it means that it is absent.
3. If target < low or target > high, stop.


Runtime Complexity: O(logn) + O(logn) = O(2logn) = O(logn)
Space Complexity: O(1)

Yes, it ran on leetcode
No problems
"""

from typing import List


class Solution:
    # Combine both binary searches, but runtime complexity is same
    def binarySearchLeft(self, nums, target, low, high):
        # first occurrence
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:  # first element, so don't move left else exception, left <
                    # mid
                    return mid
                else:  # keep moving left while mid == mid - 1
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
        return -1

    def binarySearchRight(self, nums, target, low, high):  # low can be left as it is already computed
        # last occurrence
        while (low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[
                    mid + 1]:   # last element, so don't move right else exception, right > mid
                    return mid
                else:  # keep moving right while mid == mid + 1
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # empty list i.e. no null also and edge cases
        if len(nums) == 0 or target < nums[0] or target > nums[-1]:
            # all elements in list are none or null
            return [-1, -1]

        left = self.binarySearchLeft(nums, target, 0, len(nums) - 1)  # first occurrence
        if left == -1:
            return [-1, -1]
        right = self.binarySearchRight(nums, target, 0, len(nums) - 1)  # last occurrence
        return [left, right]
