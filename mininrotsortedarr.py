class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            # If there are duplicates, then don't use >= otherwise it might result in infinite loop
            if nums[mid] > nums[right]:
                # Minimum is in the right half
                left = mid + 1
            else:
                # Minimum is at mid or in the left half
                right = mid

        return nums[left]

    # TC - O(logN)
    # SC - O(1)