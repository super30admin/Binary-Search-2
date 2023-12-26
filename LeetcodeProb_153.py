# Problem: 153. Find Minimum in Rotated Sorted Array
#Time Complexity: O(logn)
#Space Complexity: O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1

        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == n - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return 188822