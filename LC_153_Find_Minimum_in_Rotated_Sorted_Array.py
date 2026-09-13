from typing import List

"""
Optimized Solution: Binary Search

Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 153. Find Minimum in Rotated Sorted Array) : Yes
Any problem you faced while coding this : None

Approach:
We use modified binary search, first checking if the current subarray (nums[left..right]) is already sorted — if nums[left] <= nums[right], the minimum is simply nums[left].
Otherwise the subarray is rotated, so we compute mid and check whether nums[mid] is smaller than both its neighbors, which would mean it's the rotation point (the minimum itself).
If not, we determine which half is properly sorted by comparing nums[left] to nums[mid], and move into the other half, since the minimum must lie in the unsorted half.
"""
class Solution:
    def find_min(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return -1
        left = 0
        right = len(nums) - 1
        while left <= right:
            if nums[left] <= nums[right]:
                return nums[left]
            mid = left + (right - left) // 2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[left] <= nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return -1


def run_tests():
    test_cases = [
        # (nums, expected)
        ([3, 4, 5, 1, 2], 1),
        ([4, 5, 6, 7, 0, 1, 2], 0),
        ([11, 13, 15, 17], 11),
        ([1], 1),
        ([2, 1], 1),
        ([1, 2], 1),
        ([5, 1, 2, 3, 4], 1),
        ([], -1),
    ]

    solver = Solution()
    print("--- Testing Binary Search ---")
    for nums, expected in test_cases:
        result = solver.find_min(nums)
        status = "PASS" if result == expected else "FAIL"
        print(f"{status}: nums={nums}, expected={expected}, got={result}")


if __name__ == "__main__":
    run_tests()