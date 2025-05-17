# Time Complexity : O(log n) where n = len(nums)
# Space Complexity : O(1) auxiliary
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # if the list is empty, return [-1, -1] right away
        if not nums:
            return [-1, -1]
        

        # Helper to find the first and last position of target.
        def binary_search(nums, target, is_search_left) -> int:

            left = 0
            right = len(nums) - 1
            idx = -1

            while left <= right:
                mid = (left+right) // 2

                if nums[mid] > target:
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    idx = mid
                    if is_search_left:
                        right = mid - 1
                    else:
                        left = mid + 1
            return idx
        

        left = binary_search(nums, target, True)
        right = binary_search(nums, target, False)

        return [left, right]


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    nums1, tgt1 = [5, 7, 7, 8, 8, 10], 8
    print(sol.searchRange(nums1, tgt1))  # expected [3, 4]

    # Example 2
    nums2, tgt2 = [5, 7, 7, 8, 8, 10], 6
    print(sol.searchRange(nums2, tgt2))  # expected [-1, -1]

    # Example 3 (empty array)
    nums3, tgt3 = [], 0
    print(sol.searchRange(nums3, tgt3))  # expected [-1, -1]
