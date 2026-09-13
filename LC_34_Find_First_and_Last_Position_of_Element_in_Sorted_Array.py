from typing import List

"""
Brute Force Solution: Linear Scan

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 34. Find First and Last Position of Element in Sorted Array) : Yes
Any problem you faced while coding this : None

Approach:
We scan the array once from the left to find the first index where nums[i] equals target, and once from the right to find the last such index.
If the target is never found in either pass, both indices stay at -1, correctly signaling that it's absent.
This is straightforward and always correct, but doesn't exploit the fact that the array is sorted, so it can't beat O(n).
"""

class SolutionLinear:
    def search_range(self, nums: List[int], target: int) -> List[int]:
        left = -1
        right = -1
        for i in range(len(nums)):
            if nums[i] == target:
                left = i
                break
        for j in range(len(nums) - 1, -1, -1):
            if nums[j] == target:
                right = j
                break
        return [left, right]



"""
Optimized Solution: Binary Search

Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 34. Find First and Last Position of Element in Sorted Array) : Yes
Any problem you faced while coding this : None

Approach:
We run two independent modified binary searches over the sorted array — one biased to converge on the leftmost occurrence of target, one biased toward the rightmost.
In each search, whenever nums[mid] equals target we don't stop immediately; we check the neighboring element to confirm we're actually at the boundary of the target's run, otherwise we keep narrowing in that direction.
This lets us discard half the search space each iteration, finding both bounds in O(log n) instead of scanning the whole array.
"""

class SolutionBinarySearch:
    def search_range(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        if nums[0] > target or nums[-1] < target:
            return [-1, -1]

        first_index = self.find_start_index(nums, target)
        last_index = self.find_last_index(nums, target)

        return [first_index, last_index]

    def find_start_index(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                right = mid - 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

    def find_last_index(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                    return mid
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1


def run_tests():
    test_cases = [
        # (nums, target, expected)
        ([5, 7, 7, 8, 8, 10], 8, [3, 4]),
        ([5, 7, 7, 8, 8, 10], 6, [-1, -1]),
        ([], 0, [-1, -1]),
        ([1], 1, [0, 0]),
        ([1], 2, [-1, -1]),
        ([2, 2, 2, 2, 2], 2, [0, 4]),
        ([1, 2, 3, 4, 5], 1, [0, 0]),
        ([1, 2, 3, 4, 5], 5, [4, 4]),
        ([1, 2, 3, 4, 5], 3, [2, 2]),
        ([1, 3], 2, [-1, -1]),
    ]

    solutions = {
        "Linear": SolutionLinear(),
        "BinarySearch": SolutionBinarySearch(),
    }

    for name, solver in solutions.items():
        print(f"--- Testing {name} ---")
        for nums, target, expected in test_cases:
            result = solver.search_range(nums, target)
            status = "PASS" if result == expected else "FAIL"
            print(f"{status}: nums={nums}, target={target}, "
                  f"expected={expected}, got={result}")
        print()


if __name__ == "__main__":
    run_tests()