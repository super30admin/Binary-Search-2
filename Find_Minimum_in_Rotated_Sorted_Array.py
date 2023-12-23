#time complexity: O(log n)
#space complexity: O(1)


class Solution:
    def findMin(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if nums[0] <= nums[len(nums) - 1]:  # to check array is sorted(both sides) --1
            return nums[0]
        
        low = 0
        high = len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]:  # similar to --1
                return nums[low]
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]  # if middle element itself is the smallest
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 45678
