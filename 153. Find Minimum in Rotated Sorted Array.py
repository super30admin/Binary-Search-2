# Time complexity: O(log n)
# Space complexity: O(1)


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low < high:
            mid = low + (high-low) // 2
            # The min has to be on right side as the pivot is there
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                # not mid - 1 is to ensure we don't skip the middle element if it's the minimum
                high = mid
        return nums[low]