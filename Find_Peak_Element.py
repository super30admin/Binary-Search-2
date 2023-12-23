#time complexity: O(log n)
#space complexity: O(1)

class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 0

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            # checking if middle is the peak
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid < len(nums) - 1 and nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        
        
        