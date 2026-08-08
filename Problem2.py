# Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Time Complexity: O(log n),We cut the search range in half every iteration using binary search logic
# Space Complexity: O(1),We only use a few variables like low, high and mid, no extra data structures
# Approach:
# The array is sorted then rotated, so it is made of two sorted pieces joined together
# At each mid, compare nums[mid] with nums[high] to figure out which side is sorted
# If nums[mid] <= nums[high], the right side from mid to high is sorted, so the minimum cannot be to the right of mid, it is either mid itself or somewhere on the left, so shrink high to mid
# If nums[mid] > nums[high], the rotation point lies between mid and high, so mid cannot be the minimum and the minimum must be somewhere to the right, so shrink low to mid plus one
# When low equals high, that single index holds the minimum value

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1
        # low and high mark the current search range, start with the whole array

        while low < high:
            # keep shrinking the range until only one index is left

            mid = low + (high - low) // 2
            # pick the middle index of the current range

            if nums[mid] <= nums[high]:
                # right side from mid to high is sorted, no rotation point inside it
                # so the minimum is either mid or somewhere to the left of mid
                high = mid
                # keep mid inside the search range since it could be the answer

            else:
                # nums[mid] > nums[high] means the rotation point is between mid and high,so mid itself cannot be the minimum
                low = mid + 1
                # safe to exclude mid entirely

        return nums[low]
        # when low equals high, that single remaining index holds the minimum