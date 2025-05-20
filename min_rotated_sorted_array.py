# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def findMin(self, nums: list[int]) -> int:
        if not nums:
            return -1
        start = 0
        end = len(nums) - 1
        pivot = nums[-1]
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] <= pivot and (mid == 0 or nums[mid - 1] > nums[mid]):
                return nums[mid]
            elif nums[mid] > pivot:
                start = mid + 1
            else:
                end = mid - 1
        return -1
