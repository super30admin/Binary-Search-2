class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def findLeft():
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return left

        def findRight():
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] <= target:
                    left = mid + 1
                else:
                    right = mid - 1
            return right

        left_index = findLeft()
        right_index = findRight()

        # Check if target is actually present
        if left_index <= right_index:
            return [left_index, right_index]
        return [-1, -1]

nums = [5, 7, 7, 8, 8, 10]
target = 8

sol = Solution()
print(sol.searchRange(nums, target))  # Output: [3, 4]

# Time Complexity:
#   O(log n), where n is the number of elements in the array
#   We perform binary search twice — once to find the first occurrence,
#   and once to find the last occurrence of the target.

# Space Complexity:
#   O(1) — only a constant number of variables are used

# Did this code successfully run on Leetcode: Yes, 34 (Find First and Last Position of Element in Sorted Array)

# Any problem you faced while coding this:
#   Yes — initially confused about how to differentiate between finding the left vs. right boundary.
#   Learned that:
#     - for the first position, we move right = mid - 1 when nums[mid] == target
#     - for the last position, we move left = mid + 1 when nums[mid] == target
#   This ensures we capture the exact leftmost and rightmost indices of the target value.
