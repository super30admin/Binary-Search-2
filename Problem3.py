class Solution:
    # Time Complexity: O(log n)
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n - 1
        while low <= high:
            mid = int(low + (high - low) / 2)
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (
                mid == n - 1 or nums[mid] > nums[mid + 1]
            ):
                return mid
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return
