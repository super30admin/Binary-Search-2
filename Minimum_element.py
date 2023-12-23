#Time Complexity:- O(log n)
#Space Complexity:- O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:  # Handle empty list
            return -1  # Return -1 (or any other suitable value) for no minimum element found

        low = 0  # Set low = 0
        high = len(nums) - 1  # Set high to the last index

        # Check if the array is sorted or not
        if nums[low] <= nums[high]:
            return nums[low]

        # Binary Search
        while low <= high:
            mid = low + (high - low) // 2

            # Check if mid is the minimum element
            if nums[mid] < nums[mid - 1]:
                return nums[mid]

            # Check if mid is greater than high
            if nums[mid] > nums[high]:
                low = mid + 1  # Left half is sorted, move to the right half

            else:
                high = mid - 1  # Right half is sorted, move to the left half

        return -1  # Return -1 for no minimum element found
