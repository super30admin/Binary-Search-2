# Check if current segment is sorted: If nums[low] <= nums[high], then the smallest element is at low because the array is sorted without rotation in this segment.

# Check middle element against neighbors: The minimum element is smaller than both its neighbors in the rotated sorted array, so check if nums[mid] satisfies this.

# Adjust search space: If nums[mid] is greater or equal to nums[low], minimum must be to the right, else it’s on the left side. Use this to narrow down search in O(log n) time.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        # If array is already sorted (no rotation), the first element is minimum
        low, high = 0, len(nums) - 1
        n = len(nums)

        while low <= high:
            # If the current segment is sorted, return the first element
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2
            prev = (mid - 1 + n) % n
            next = (mid + 1) % n

            # Check if mid is the minimum (smaller than neighbors)
            if nums[mid] < nums[prev] and nums[mid] < nums[next]:
                return nums[mid]

            # Decide which side to search next
            if nums[mid] >= nums[low]:
                low = mid + 1
            else:
                high = mid - 1

        return nums[0]  # fallback (should not reach here if input is valid)
