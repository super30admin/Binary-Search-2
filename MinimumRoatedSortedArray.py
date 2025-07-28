class Solution(object):
    def findMin(self, nums):
        # Initialize two pointers at the start and end of the array
        left, right = 0, len(nums) - 1

        # Perform binary search until the search space is narrowed to one element
        while left < right:
            # Calculate the middle index
            mid = (left + right) // 2

            # If the mid element is greater than the rightmost element,
            # it means the smallest value is in the right half
            if nums[mid] > nums[right]:
                # So we move the left pointer just after mid
                left = mid + 1
            else:
                # Otherwise, the smallest value is at mid or in the left half
                # So we move the right pointer to mid
                right = mid

        # At the end of the loop, left == right, pointing to the minimum element
        return nums[left]
