from typing import List

"""
Optimized Solution: Binary Search

Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode (Problem 162. Find Peak Element) : Yes
Any problem you faced while coding this : None

Approach:
We use modified binary search, checking at each step whether nums[mid] is greater than both its neighbors, which would mean it's a peak.
If not, we compare nums[mid] with nums[mid + 1]: if the next element is larger, a peak must exist somewhere to the right, so we move low forward.
Otherwise, a peak must exist to the left (including mid itself), so we move high backward, and we repeat until the search space converges on a peak.
"""
class Solution:
    def find_peak_element(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == n - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1


def run_tests():
    test_cases = [
        # (nums, expected_possible_indices)
        ([1, 2, 3, 1], [2]),
        ([1, 2, 1, 3, 5, 6, 4], [1, 5]),
        ([1], [0]),
        ([1, 2], [1]),
        ([2, 1], [0]),
        ([1, 2, 3, 4, 5], [4]),
        ([5, 4, 3, 2, 1], [0]),
    ]

    solver = Solution()
    print("--- Testing Binary Search ---")
    for nums, expected_possible_indices in test_cases:
        result = solver.find_peak_element(nums)
        status = "PASS" if result in expected_possible_indices else "FAIL"
        print(f"{status}: nums={nums}, expected one of={expected_possible_indices}, got={result}")


if __name__ == "__main__":
    run_tests()