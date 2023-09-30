# Time Complexity - O(log n) as binary search is being used 
# Space Complexity - O(1) as no extra space is being used 

# Approach - As peak is defined as number that is greater than the neighbours,
# when we reach boundary conditions, to handle the cases, we use inf and -inf

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0; high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
                        # Check the left boundary
            left_val = nums[mid - 1] if mid > 0 else float('-inf')
            # Check the right boundary
            right_val = nums[mid + 1] if mid < len(nums) - 1 else float('-inf')

            if nums[mid] > left_val and nums[mid] > right_val:
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1